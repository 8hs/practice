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
}
