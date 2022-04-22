package leetcode;

import net.weever.leetcode.StringSolution;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StringTest {

    StringSolution ss = new StringSolution();

    @Test
    public void test(){
        System.out.println(Integer.valueOf("001"));
        String s = IntStream.range(0, 10)
                .mapToObj(i -> i+"x")
                .collect(Collectors.joining());
        System.out.println(s);

    }

    @Test
    public void test1() {
        System.out.println(ss.compareVersion("1.0.1","1"));
    }

    @Test
    public void testDecode() {
        String result = ss.decodeString("23[a]56[b]89[c]");
        System.out.println(result);
        result = ss.decodeString("3[a2[c]]");
        System.out.println(result);
        result = ss.decodeString("2[abc]3[cd]ef");
        System.out.println(result);

    }
}
