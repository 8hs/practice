package net.weever.datastructure;

import net.weever.domain.ListNode;



/**
 * Created by lixp1 on 8/11/2014.
 */
public class LinkedListStack {

    private ListNode top;

    public int pop(){
        if(top==null) return -1;
        int num = top.val;
        top = top.next;
        return num;
    }
    public void push(int x){
        ListNode node = new ListNode(x);
        node.next = top;
        top = node;
    }

    public int peek(){
        if(top!=null) return top.val;
        return -1;
    }
}
