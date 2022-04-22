package leetcode;

import net.weever.interview.Amazon;
import org.junit.Test;

public class AmazonTest {

    Amazon amazon = new Amazon();

    @Test
    public void testClose() {
        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int arr2[][] = { {1, 5000 }, {2, 3000} };

        int[] result = amazon.getClosestPairs(arr1, arr2, 50000);

        System.out.println(result[0] + ":" + result[1]);
    }
}
