package net.weever.test;

import net.weever.Solution;
import net.weever.datastructure.Queue;
import net.weever.datastructure.QueueArray;
import net.weever.domain.ListNode;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {3,4,5,1,4,2};
		int[] B = {9,9,9};
		int[] C = {2,1};
		int target = 6;
		Solution sl = new Solution();
		//int[] result = sl.twoSum(A, target);
		int[] result = sl.PlusOne(A);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
		
		String s = "the sky is blue";
		System.out.println(sl.candy(C));
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		//printList(sl.sortList(n1));
		
		StackTest stktest = new StackTest();
		System.out.println("peek is: " +stktest.stk.peek());
		stktest.testStackArray();
		
		//queue test
		QueueArray<String> queue= new QueueArray<String>();
		queue.enqueue("Hello").enqueue("world");
		System.out.println(queue.dequeue()+","+queue.dequeue());
		

		//missing postive int
		int[] uu = {2,1};
		System.out.println(sl.firstMissingPositive(uu));
		

		// permutation test
		System.out.println(sl.getPermutation(1, 1));
		
		System.out.println(2^2);

	}
	
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}

}
