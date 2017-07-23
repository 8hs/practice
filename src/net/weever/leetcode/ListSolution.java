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
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k){
        if(k == 0){
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++){
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
        // 1,2
    }

    public static void main(String[] argus){
        new ListSolution().combine(4,2);
    }
}
