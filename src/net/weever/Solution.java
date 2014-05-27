package net.weever;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import net.weever.domain.ListNode;
import net.weever.domain.RandomListNode;
import net.weever.domain.TreeNode;

public class Solution {
	/*
	Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
	You may assume that each input would have exactly one solution.
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
	 */
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

/*
 * 	 Sort a linked list in O(n log n) time using constant space complexity.
 */
	 public ListNode sortList(ListNode head) {
	      if(head == null || head.next == null)
	    	  return head;
	      
	      //get the length of the liklist
	      int count = 0;
	      ListNode node = head;
	      while(node!=null){
	    	  count++;
	    	  node = node.next;
	      }
	      
	      
	      //break up to two list
	      int middle = count / 2;
	      
	      ListNode middleNode = head, rightlisthead = null;
	      int countHalf = 1;
	      while(countHalf < middle){
	    	  countHalf++;
	    	  middleNode = middleNode.next;
	      }
	      rightlisthead = middleNode.next;
	      middleNode.next = null;
		 
	      //recursively break until it can not break
	      ListNode left = sortList(head);
	      ListNode right = sortList(rightlisthead);
	      
	      //combine and return the head of new sorted linkList
	      return merge(left,right);
	    }
	 
	 private static ListNode merge(ListNode leftlist,ListNode rightlist){
		 
		 ListNode head,currentNode, nextNode;
		 
		 if(leftlist == null)
			 return rightlist;
		 else if(rightlist == null)
			 return leftlist;
		 else if(leftlist.val <= rightlist.val){
			 head = leftlist;
			 currentNode = leftlist;
			 nextNode = rightlist;
		 } else {
			 head = rightlist;
			 currentNode = rightlist;
			 nextNode = leftlist;
		 }
		 
		 ListNode temp;
		 
		 while(nextNode !=null){
			 if(currentNode.next == null){
				 currentNode.next = nextNode;
				 nextNode = null;
			 }
			 else if(currentNode.next.val <= nextNode.val){
				 currentNode = currentNode.next;
			 } else {
				 temp = currentNode.next;
				 currentNode.next = nextNode;
				 nextNode = temp;
			 }
		 }
		 
		 return head;
	 }

	 
	 public int trap(int[] A) {
		 if(A.length<3) return 0;
		 int[] maxL = new int[A.length];
		 int[] maxR = new int[A.length];
		 int max = A[0];
		 maxL[0] = 0;
		 
		 for(int i =1;i<A.length-1;i++){
			 maxL[i] = max;
			 if(max<A[i]) max =A[i];
		 }
		 max = A[A.length-1];
		 maxR[A.length-1] = 0;
		 for(int i = A.length -2 ;i>0;i--){
			 maxR[i] = max;
			 if(A[i]>max) max= A[i];
		 }
		 int total = 0;
		 for(int i = 1;i<A.length-1;i++){
			 int volum = Math.min(maxL[i], maxR[i])-A[i];
			 if(volum>0) total += volum;
		 }
		 
		 return total;
	 }
	 
	 public int firstMissingPositive(int[] A) {
	        int len = A.length;
	        if(len == 1 && A[0] != 1) return 1;
	        
	        int i = 0;
	        while (i<len){
	        	if(A[i] != (i+1) && A[i] >= 1 && A[i] <= len && A[A[i]-1] != A[i]){
	        		int temp = A[i];
	        		int index = A[i]-1;
	        		A[i] = A[A[i]-1];
	        		A[index] = temp;
	        	} else {
	        		i++;
	        	}
	        }
	        
	        for(int j = 0; j< len;j++){
	        	if(A[j]!=j+1)
	        		return j+1;
	        }
	        return len+1;
	    }

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 */
	 public boolean hasPathSum(TreeNode root, int sum){
		 if(root == null) return false;
		 
		 LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		 LinkedList<Integer> sumValu = new LinkedList<Integer>();
		 
		 nodes.add(root);
		 sumValu.add(root.val);
		 
		 
		 while(!nodes.isEmpty()){
			 
			 TreeNode currentNode = nodes.poll();
			 int total = sumValu.poll();
			 
			 if(currentNode.left == null && currentNode.right == null && total == sum){
				 return true;
			 }
			 
			 if(currentNode.left != null){
				 nodes.add(currentNode.left);
				 sumValu.add(total+currentNode.left.val);
			 }
			 
			 if(currentNode.right != null){
				 nodes.add(currentNode.right);
				 sumValu.add(total+currentNode.right.val);
			 }
			 
		 }
		 
		 return false;
		 
	 }

	 
	 public String getPermutation(int n, int k) {
	      ArrayList<Integer> ll = new ArrayList<Integer>();
	      int mod = 1;
	      for(int i = 1; i<=n;i++){
	          ll.add(i);
	          mod = mod*i;
	      }
	      
	      k--;
	      
	      String result = "";
	      for(int i = 0; i<n;i++){
	    	  mod = mod / ( n- i);
	    	  int index = k / mod;
	    	  k = k % mod;
	    	  result += ll.get(index);
	    	  ll.remove(index);
	      }
	      
	      return result;
	 }
	 /*
	  *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	  *  Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
	  */
	 public void sortColors(int[] A) {
	       
	 }
	  /* 
	   * Given a collection of numbers, return all possible permutations.
	   * For example,
	   * [1,2,3] have the following permutations:
	   * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].   
	   */
	    public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        result.add(new ArrayList<Integer>());
	        
	        for (int i = 0; i < num.length; i++) {
	            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	            
	            for(ArrayList<Integer> l : result){
	                for(int j=0;j<l.size()+1;j++){
	                    l.add(j,num[i]);
	                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
	                    current.add(temp);
	                    l.remove(j);
	                }
	            }
	            result = new ArrayList<ArrayList<Integer>>(current);
	        }
	        return result;
	    }
	    
	    /*
	     * The problem:
	     * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
	     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→... 
	     * For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this in-place without altering the nodes' values. 
	     */
	    public void reorderList(ListNode head){
	    	if(head != null && head.next != null){
	    		ListNode slow = head;
	    		ListNode fast = head;
	    		
	    		while(fast!=null && fast.next!=null&&fast.next.next!=null){
	    			slow = slow.next;
	    			fast=fast.next.next;
	    		}
	    		
	    		ListNode second = slow.next;
	    		slow.next = null;
	    		
	    		second = reverseOrder(second);
	    		
	    		ListNode list1 = head;
	    		ListNode list2 = second;
	    		
	    		while(list2!=null){
	    			ListNode temp1 = list1.next;
	    			ListNode temp2 = list2.next;
	    			
	    			list1.next = list2;
	    			list2.next = temp1;
	    			
	    			list1 = temp1;
	    			list2 = temp2;
	    		}
	    	}
	    }
	    
	    private static ListNode reverseOrder(ListNode head){
	    	if(head == null || head.next ==null) return head;
	    	
	    	ListNode pre = head;
	    	ListNode current = head.next;
	    	
	    	while(current!=null){
	    		ListNode temp = current.next;
	    		current.next = pre;
	    		pre = current;
	    		current = temp;
	    	}
	    	
	    	head.next = null;
	    	return pre;
	    }
/*
 * 
 */
	 public RandomListNode copyRandomList(RandomListNode head) {
		 	
		 if(head == null) return null;
		 
		 HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	     RandomListNode newHead = new RandomListNode(head.label);
	     
	     map.put(head, newHead);
	     
	     RandomListNode original = head;
	     RandomListNode copy = newHead;
	     
	     original = original.next;
	     while(original!=null){
	    	 
	    	 RandomListNode temp = new RandomListNode(original.label);
	    	 map.put(original, temp);
	    	 copy.next = temp;
	    	 copy = temp;
	    	 original = original.next;
	     }
	     
	     original = head;
	     copy = newHead;
	     
	     while(original!=null){
	    	 
	    	 if(original.random != null){
	    		 copy.random = map.get(original.random) ;
	    	 }else{
	    		 copy.random = null;
	    	 }
	    	 
	    	 original = original.next;
	    	 copy = copy.next;
	     }
        
	        return newHead;
	    }

	 
}
