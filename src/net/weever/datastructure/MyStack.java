package net.weever.datastructure;

import java.util.Arrays;

public class MyStack<E> {

	private int top;
	private static final int DEFAULT_CAPACITY = 10;
	private Object element[];
	
	public MyStack(){
		element = new Object[DEFAULT_CAPACITY];
		top = -1;
	}
	
	public MyStack(int size){
		element = new Object[size];
		top = -1;
	}
	
	public void push(E e){
		if(top == element.length){
			increCapa();
		}
		element[++top] = e;
	}
	
	public E pop(){
		E e = (E) element[top--];
		element[top+1] = null;
		return e;
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public E peek(){
		return (E)element[top];
	}

	private void increCapa(){
		int newsize = element.length * 2;
		element = Arrays.copyOf(element, newsize);
	}
}
