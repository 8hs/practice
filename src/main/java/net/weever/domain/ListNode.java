package net.weever.domain;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class ListNode {

	public int val; 
	public ListNode next; 

    public ListNode(){
        val = 0;
        next =null;
    }
	public ListNode(int x) { 
		val = x; 
		next = null; 
	}

    public void appendToTail(int x){
        ListNode newNode = new ListNode(x);
        ListNode node = this;
        while(node.next!=null) {
            node = node.next;
        }
        node.next = newNode;
    }

    public void deleteDupNode(ListNode head){
        if(head == null) return;
        Hashtable table = new Hashtable();
        ListNode pre = null;
        while(head.next!=null){
            if(table.contains(head.val)){
                pre.next = head.next;
            }else{
                table.put(head.val,true);
                pre = head;
            }

            head = head.next;
        }
   }
    public void deleteDupNodeInPlace(ListNode head){
        if(head == null) return;

        ListNode current = head;

        while(current != null){
            ListNode runner = current;
            while(runner.next!=null){
                if(current.val == runner.next.val)
                    runner.next = runner.next.next;
                runner = runner.next;
            }
            current = current.next;
        }

    }
    /**
     * To delete current node, copy the next node's val and next point to replace
     * the current node
     */
    public static boolean deleteNode(ListNode node){
        if(node == null || node.next ==null)
            return false;
        ListNode next = node.next;
        node.val = next.val;
        node.next =next.next;
        return true;
    }

}
