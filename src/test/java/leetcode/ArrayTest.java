package leetcode;

import net.weever.leetcode.ArraySolution;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTest {

    ArraySolution solution = new ArraySolution();

    @Test
    public void test_rotate() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(solution.rotate(nums, 3)));
    }

    @Test
    public void test_nextP() {
        int[] nums = solution.nextPermutation2(new int[]{7, 8, 3, 5, 4, 2});
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test() {
        Arrays
                .stream(new int[]{7, 8, 3, 5, 4, 2})
                .forEachOrdered( x -> System.out.println(x));

        String s = "HelloWorld";
        char[] cs = s.toCharArray();

        List<Character> list = IntStream.range(0, cs.length)
                .mapToObj(i -> cs[i])
                .collect(Collectors.toList());

        list.remove(Character.valueOf('a'));

        Collections.sort(list, Collections.reverseOrder());

        String output = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(output);
        
        
        

    }
}
