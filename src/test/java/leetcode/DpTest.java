package leetcode;

import net.weever.leetcode.DynamicProgrammming;
import org.junit.Test;

import java.util.*;

public class DpTest {

    DynamicProgrammming dp = new DynamicProgrammming();

    @Test
    public void coinTest() {
        int[] coins = new int[]{1,2};
        int res = dp.coinChange(coins, 4);
        System.out.println(res);
    }


    @Test
    public void wordBreak() {
        List<String> wordDict = Arrays.asList("leet","code");
        List<String> wordDict2 = Arrays.asList("apple","pen");
        List<String> wd3 = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(dp.wordBreak("leetcode", wordDict));
        System.out.println(dp.wordBreak("applepenapple", wordDict2));
        System.out.println(dp.wordBreak("catsandog", wd3));
    }

    @Test
    public void findSentence() {
        String input = "Wedonotknow";
        List<String> list = Arrays.asList("we", "do", "not", "know");
        Set<String> dict = new HashSet<>(list);
        dp.sortSentence(input, dict);
    }

    @Test
    public void test() {
        String s = "abc";
        System.out.println(s.substring(2));
    }
}
