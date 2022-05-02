package net.weever.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amazon {

    public int[] getClosestPairs(int[][] a, int[][] b, int target ) {
//        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
//        int arr2[][] = { {1, 5000 }, {2, 3000} };
        List<AirTime> arr1 = new ArrayList<>();
        for (int[] entry: a) {
            arr1.add(new AirTime(entry[0], entry[1]));
        }
        List<AirTime> arr2 = new ArrayList<>();
        for (int[] entry: b) {
            arr2.add(new AirTime(entry[0], entry[1]));
        }
        Collections.sort(arr1);
        Collections.sort(arr2);

        int[] result = new int[2];
        int close = Integer.MAX_VALUE;

        for (int i=0, j= arr2.size()-1;i< arr1.size() && j>=0;) {
            int sum = arr1.get(i).value + arr2.get(j).value;
            if (sum == target) {
                return new int[] { arr1.get(i).key, arr2.get(j).key};
            }
            if (Math.abs(sum-target) <= close) {
                close = Math.abs(sum-target);
                result[0] = arr1.get(i).key;
                result[1] = arr2.get(j).key;
            }
            if (sum > target)
                j--;
            if (sum < target)
                i++;
        }

        return result;

    }
}

class AirTime implements Comparable<AirTime>{
    int key;
    int value;

    AirTime(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(AirTime o) {
        return value - o.value;
    }
}