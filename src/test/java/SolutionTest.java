import net.weever.Solution;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private final Solution solution = new Solution();
    
    @Test
    public void testStreamToMap() {
        List<String> list = Arrays.asList("Hello", "Do", "Not", "Apple", "Hello");
        Map<String, String> map = list.stream()
                .sorted().
        collect(Collectors.toMap(s->s, s->s, (s1,s2) -> s1));

        System.out.println(map.size());
    }

    @Test
    public void testCountNicePairs() {
        int[] nums = new int[]{1,1,1,10,10,10};
        int re = solution.countNicePairs(nums);
        System.out.println(re);
    }

    @Test
    public void testIsland() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int re = solution.numIslands(grid);
        System.out.println(re);
    }

    @Test
    public void testSearchMatrixTarget() {
        int[][] matrix = new int[][]{{1,3}};
        boolean res = solution.searchMatrix(matrix, 3);
        assertTrue(res);
    }


    @Test
    public void testPrint() {
        Collection<String> list = Arrays.asList("A", "B", "C");
        String s = "{" +String.join(",", list.stream()
                .map( c -> String.format("\"%s\"", c))
                .toArray(String[]::new)) + "}";
        System.out.println(s);

        s = list.stream()
                .map( c -> String.format("\"%s\"", c))
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println(s);
    }

    @Test
    public void testS() {
        String test1 =
                "My phone number is 555-123-4567\n" +
                        "or alternatively: 555-9876543\n" +
                        "these should not get processed\n" +
                        " * 123 - too short\n" +
                        " * 5551234567 - wrong format\n" +
                        " * 555-12345678 - too long\n" +
                        "good luck!!";
        solution.detectPhoneNumbers(test1);
    }

    /**
     * 已知 rand_N() 可以等概率的生成[1, N]范围的随机数
     * 那么：
     * (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
     * 即实现了 rand_XY()
     */

}
