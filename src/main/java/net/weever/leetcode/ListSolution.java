package net.weever.leetcode;

import net.weever.domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by localadmin on 5/14/17.
 */
public class ListSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        ListNode atail = null;
        ListNode btail = null;

        while(true){
            if(a.next == null){
                a.next = headB;
                atail = a;
            }
            if(b.next == null){
                b.next = headA;
                btail = b;
            }
            if(atail != null && btail != null && btail != atail)
                return null;
            if(a == b)
                return a;
            a= a.next;
            b= b.next;
        }
    }

    //77. Combinations
    //backtracking recursive + iterator
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k){
        if(k == 0){
            combs.add(new ArrayList<>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
        // 1,2
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while(l1 != null || l2 !=null || carry == 1) {
            int i = (l1 != null ? l1.val : 0);
            int j = (l2 != null ? l2.val : 0);
            int value = (i+j+carry)%10;
            carry = (i+j+carry)/10;
            pointer.next = new ListNode(value);
            pointer = pointer.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] argus){
        new ListSolution().combine(4,2);
    }
}
