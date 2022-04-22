package net.weever.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DynamicProgrammming {

    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        dp(coins, amount, 0);
        if(min < Integer.MAX_VALUE)
            return min;
        return -1;
    }

    private void dp(int[] coins, int remainder, int count) {
        if (remainder == 0) {
             min = Math.min(min, count);
             return;
        }
        if (remainder < 0) {
            return;
        }
        for(int num: coins) {
            dp(coins, remainder-num, count+1);
        }
    }

    /**
     * 300
     * https://leetcode.com/problems/longest-increasing-subsequence/
     */
    public int lengthOfLIS(int[] nums) {
        return  0;
    }

    /**
     * 139 https://leetcode.com/problems/word-break/
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] find = new boolean[s.length()+1];

        find[0] = true;

        for (int i= 1; i<=s.length(); i++)
            for (int j=0; j<i; j++) {
                if (find[j] && dict.contains(s.substring(j, i)))
                    find[i] = true;
            }
         return find[s.length()];
    }


    public void sortSentence(String input, Set<String> dict) {
        List<String> result = new ArrayList<>();
        dfs(input, dict, result);
    }

    private void dfs(String restWord, Set<String> dict, List<String> result) {
        if(restWord.equals("")) {
            String s = result.stream()
                    .collect(Collectors.joining(" "));
            System.out.println(s);
            return;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i< restWord.length(); i++) {
            sb.append(restWord.charAt(i));
            if (dict.contains(sb.toString().toLowerCase())) {
                result.add(sb.toString());
                dfs(restWord.substring(i+1), dict, result);
                result.remove(result.size()-1);
            }
        }
    }
}
