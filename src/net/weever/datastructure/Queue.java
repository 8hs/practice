package net.weever.datastructure;

import java.util.NoSuchElementException;

public class Queue<E> {
	
	private int total;
	private Node first,last;
	
	private class Node{
		private E e;
		private Node next;
	}
	
	public Queue(){
		
	}
	
	public Queue<E> enqueue(E e){
		Node current = last;
		last = new Node();
		last.e = e;
		
		if(total++ ==0) first = last;
		else current.next = last;
		
		return this;
	}
	
	public E dequeue(){
		if(total == 0) throw new NoSuchElementException();
		E e = first.e;
		first = first.next;
		if(--total == 0) last = null;
		return e;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Node temp = first;
		while (temp!=null){
			sb.append(temp.e).append(",");
			temp=temp.next;
		}
		return sb.toString();
	}
}
