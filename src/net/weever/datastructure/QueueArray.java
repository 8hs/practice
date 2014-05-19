package net.weever.datastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueArray<E> {

	private E[] arr;
	private int total,first,next;
	
	public QueueArray(){
		arr = (E[]) new Object[2];
	}
	
	private void resize(int capacity){
		E[] tmp = (E[]) new Object[capacity];
		tmp = Arrays.copyOfRange(arr, first,arr.length-1);
		arr = tmp;
		first = 0;
		next = total;
	}
	
	public QueueArray<E> enqueue(E e){
		if(arr.length == total) resize(arr.length*2);
		arr[next++] = e;
		if(next==arr.length) next = 0;
		total++;
		return this;
	}
	
	public E dequeue(){
		if(total ==0) throw new NoSuchElementException();
		E e = arr[first];
		arr[first] = null;
		if(++first == arr.length) first = 0;
		if(--total >0 && total == arr.length / 4) resize(arr.length/2);
		return e;
	}
}
