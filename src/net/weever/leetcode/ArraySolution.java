package net.weever.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public void nextPermutation(int[] nums) {
    if(nums == null || nums.length == 1) return;
    int index = nums.length - 1;
    while(nums[index] < nums[index-1] && index > 0)
      index--;
    if(index == 0){
      reverseArray(nums,0,nums.length-1);
      return;
    }
    int val = nums[index-1];
    int j = nums.length - 1;
    while(val > nums[j]) j--;
    nums[index-1] = nums[j];
    nums[j] = val;
    reverseArray(nums, index, nums.length-1);
  }

  public void reverseArray(int[] nums, int start, int end){
    while(start > end){
      int t = nums[start];
      nums[start++] = nums[end];
      nums[end--] = t;
    }
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for(Integer num:nums1){
      if(map.containsKey(num))
        map.put(num,map.get(num)+1);
      else
        map.put(num,1);
    }

    for(Integer num:nums2){
      if(map.containsKey(num) && map.get(num) >0){
        result.add(num);
        map.put(num,map.get(num) -1);
      }

    }

    int[] r = new int[result.size()];
    int index = 0;
    for(Integer i : result)
      r[index++] = i;

    return r;
  }


  //49 Group Anagrams
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if(strs == null || strs.length == 0)
      return result;
    Map<String,List<String>> map = new HashMap<>();
    for(String s : strs){
      String sorted =
              Stream.of(s.split(""))
                      .sorted()
                      .collect(Collectors.joining());
      if(map.containsKey(sorted)){
        map.get(sorted).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(sorted, list);
      }
    }

    for(Map.Entry<String, List<String>> entry : map.entrySet()){
      result.add(entry.getValue());
    }
    return result;
  }

  public static void main(String[] args){
    new ArraySolution().nextPermutation(new int[]{7,8,3,5,4,2});
  }
}
