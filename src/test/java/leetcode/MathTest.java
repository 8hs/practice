package leetcode;

import net.weever.leetcode.MathSolution;
import org.junit.Test;

public class MathTest {

    MathSolution solution = new MathSolution();

    @Test
    public void testBase36() {
        System.out.println(solution.base26toBase10("A"));
        System.out.println(solution.base26toBase10("AA"));
        System.out.println(solution.base26toBase10("AAA"));
    }

    @Test
    public void testCalculate() {
        int result = solution.calculate("3+2*3/2");
        System.out.println(result);
        result = solution.calculate("3/2");
        System.out.println(result);
    }
}
