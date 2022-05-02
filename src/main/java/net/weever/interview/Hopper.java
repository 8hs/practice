package net.weever.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hopper {

    /**
     * return the shortest prefix for each word
     *  input ['dog', 'zebra', 'duck', 'dove']
     *  output ['dog','z','du','dov']
     *  assume String[] array is not null and more than two words, no null
     */
    public List<String> shortestPrefix(String[] words) {
        // prefix, count
        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            StringBuffer sb = new StringBuffer();
            for (char c : s.toCharArray()) {
                sb.append(c);
                String prefix = sb.toString();
                if(map.containsKey(prefix)) {
                    map.put(prefix, map.get(prefix) + 1);
                } else {
                    map.put(prefix, 1);
                }
            }
        }
        List<String> result = new ArrayList<>();
        outerloop:
        for (String s: words) {
            StringBuffer sb = new StringBuffer();
            for (char c : s.toCharArray()) {
                sb.append(c);
                String prefix = sb.toString();
                // if prefix is unique, then this is shortest prefix for this word
                if (map.get(prefix) == 1) {
                    result.add(prefix);
                    continue outerloop; // find prefix, go to out loop for next word
                }
            }
            // if word of prefix of other word, add itself
            result.add(s);
        }
        return result;
    }

    public static void main(String[] argus) {
        String[] words = new String[] {"dog", "zebra", "duck", "dove"};
        List<String> ans = new Hopper().shortestPrefix(words);
        System.out.println(ans.stream().collect(Collectors.joining(" ")));
    }
}
