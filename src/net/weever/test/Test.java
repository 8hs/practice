package net.weever.test;

import net.weever.Solution;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {3,4,5,1,4,2};
		int target = 6;
		Solution sl = new Solution();
		int[] result = sl.twoSum(A, target);
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}

}
