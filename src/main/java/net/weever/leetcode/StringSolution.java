package net.weever.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringSolution {

    //383. Ransom Note
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] abc = new int[26];
        for (char c : magazine.toCharArray()) abc[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--abc[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    //521. Longest Uncommon Subsequence I
    //what's the meaning of this question???
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    //171. Excel Sheet Column Number
    public int titleToNumber(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count = count * 26 + (c - 'A' + 1);
        }
        return count;
    }

    /**
     * 345. Reverse Vowels of a String
     * Write a function that takes a string as input and reverse only the vowels of a string.
     * Example 1:
     * Given s = "hello", return "holle".
     * Example 2:
     * Given s = "leetcode", return "leotcede".
     * Note:
     * The vowels does not include the letter "y".
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1)
            return s;
        String vowels = "aeiouAEIOU";
        char[] ss = s.toCharArray();
        int l = 0, r = ss.length - 1;
        while (l < r) {
            if (l < r && !vowels.contains(ss[l] + "")) {
                l++;
                continue;
            }
            if (l < r && !vowels.contains(ss[r] + "")) {
                r--;
                continue;
            }
            Character c = ss[l];
            ss[l] = ss[r];
            ss[r] = c;
            l++;
            r--;
        }
        return new String(ss);
    }

    /**
     * 520. Detect Capital
     * 1 . All capital
     * 2. all lower case
     * 3. only first capital
     */
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }


    public boolean isSubsequence(String s, String t) {
        if (s == null || s == "")
            return true;
        if (t == null || t.length() < s.length())
            return false;
        char[] ss = s.toCharArray();
        int step = 0;
        for (char c : t.toCharArray()) {
            if (c == ss[step])
                step++;
            if (step == ss.length)
                return true;
        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length())
            return result;
        int[] chars = new int[26];
        for (char c : p.toCharArray())
            chars[c - 'a']++;
        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            if (chars[s.charAt(end++) - 'a']-- > 0) {
                count--;
            }
            if (count == 0)
                result.add(start);
            if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new StringSolution().findAnagrams("cbaebabacd", "abc");
        System.out.println(new StringSolution().isSubsequence("", "sghssjh"));
        System.out.println("Response time: " + (System.currentTimeMillis() - start));
    }

    public void cellPhone(String s) {
        char[] chars = s.toCharArray();


    }

    /**
     * https://leetcode.com/problems/group-anagrams
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs == null)
            return result;

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = Stream.of(s.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(key, newList);
            }
        }
        result.addAll(map.values());
        return result;
    }


    public int compareVersion(String version1, String version2) {
        String[] va1 = version1.split("\\.");
        String[] va2 = version2.split("\\.");

        int max = Math.max(va1.length, va2.length);
        // 1 vs 1.0.1
        for (int i = 0; i < max; i++) {
            if (getValue(va1, i) > getValue(va2, i)) {
                return 1;
            } else if (getValue(va1, i) < getValue(va2, i)) {
                return -1;
            }
        }
        return 0;
    }

    private int getValue(String[] arr, int index) {
        try {
            return Integer.valueOf(arr[index]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return 0;
        }
    }

    public String decodeString(String s) {
        if(s == null)
            return null;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuffer> stringStack = new Stack<>();

        int num=0;
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()){
            if(c >= '0' && c <= '9') {
                num = num*10 + c-'0';
            } else if ( c == '[') {
                countStack.push(num);
                num = 0;
                stringStack.push(sb);
                sb = new StringBuffer();
            } else if(Character.isLetter(c)) {
                sb.append(c);
            } else {
                String cur = sb.toString();
                int count = countStack.pop();
                String repeatStr = IntStream.range(0,count)
                        .mapToObj(i -> cur)
                        .collect(Collectors.joining());
                sb = stringStack.pop();
                sb.append(repeatStr);
            }
        }
        return sb.toString();
    }

    public int findWordsCount(String sentence) {
        return 0;
    }
}
