package net.weever;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

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
			 plusone[0] = carry; int i = 1;
			 for(int a: result){
				 plusone[i++] = a;
	            }
			 return plusone;
		 }else{
			 return result;
		 }
	 }
/* 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
	 
	 public String reverseWords(String s) {
		
		 String subStr[] = s.split(" ");
		 List<String> list = Arrays.asList(subStr);
		 ListIterator<String> li = list.listIterator(subStr.length);
		 String result = "";
		 while(li.hasPrevious()){
			 String temp = li.previous();
			 if(temp.equals("") == false)
				 result = result + temp + " ";
		 }
		 
		 return result.trim();
	        
	    }

/*	 There are N children standing in a line. Each child is assigned a rating value.
	 You are giving candies to these children subjected to the following requirements:
	 Each child must have at least one candy.
	 Children with a higher rating get more candies than their neighbors.
	 What is the minimum candies you must give?
*/
	 public int candy(int[] ratings) {
	     
		 if(ratings == null) return 0;
		 
		 int people = ratings.length;
		 int[] candys = new int[ratings.length];
		 candys[0] =1;
		 for(int i=1;i<people;i++){
			 candys[i]=1;
			 if(ratings[i]>ratings[i-1]){
				 candys[i]=candys[i-1]+1;
			 } else {
				 candys[i] = 1;
			 }
		 }
		 
		 for(int j= people -1; j > 0;j--){
			 if(ratings[j] < ratings[j-1] && candys[j] >= candys[j-1]){
				 candys[j-1] = candys[j] +1;
			 }
		 }
		 
		 int sum = 0;
		 for(int a : candys)
			 sum += a;
		 
		 return sum;
		 }
	 
	 
}
