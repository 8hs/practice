package net.weever;

import java.util.HashMap;

public class Solution {
	 public int[] twoSum(int[] data, int target){
		 int[] result = new int[2];
		 HashMap<Integer, Integer> map = new  HashMap<Integer, Integer>();
		 for(int i=0;i<data.length;i++){
			 if(map.containsKey(data[i])){
				 int index = map.get(data[i]);
				 result[0] = index + 1;
				 result[1] = i+1;
			 } else {
				 map.put(target - data[i], i);
			 }
		 }
		 return result;
	 }
	 
	 public int[] PlusOne(int[] digits){
		 int carry =1,sum=0;
		 int[] result = new int[digits.length];
		 for(int i = digits.length -1; i>=0; i--){
			 sum = carry+digits[i];
			 carry = sum/10;
			 result[i] = sum%10;
		 }
		 if(carry == 1){
			 int[] plusone = new int[digits.length+1];
			 plusone[0] = carry;
			 for(int i=1;i<plusone.length;i++)
				 plusone[i] = result[i-1];
			 return plusone;
		 }else{
			 return result;
		 }
	 }
}
