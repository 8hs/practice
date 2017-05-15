package net.weever.leetcode;

public class ArraySolution {

  //561. Array Partition I
  public int arrayPairSum(int[] nums) {
    return 0;
  }

  //167. Two Sum II - Input array is sorted

  /**
   *
   * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
   * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
   * You may assume that each input would have exactly one solution and you may not use the same element twice.
   * Input: numbers={2, 7, 11, 15}, target=9
   * Output: index1=1, index2=2
   */
  public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length -1;
    while((numbers[l] + numbers[r]) != target){
      if((numbers[l] + numbers[r]) > target)
        r--;
      else
        l++;
    }
    return new int[]{l+1,r+1};
  }


  /**
   * 189. Rotate Array
   * Rotate an array of n elements to the right by k steps.
   * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
   */
  public void rotate(int[] nums, int k) {
    /*
    solution:
    1234 567 -> 765 4321
    765 4321 -> 567 4321
    567 4321 -> 567 1234
     */
  }
}
