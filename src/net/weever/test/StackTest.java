package net.weever.test;

import net.weever.datastructure.MyStack;

public class StackTest {
	
	public MyStack<Integer> stk= new MyStack<Integer>();
	
	public StackTest(){
		stk.push(1);
		stk.push(22);
		stk.push(333);
		stk.push(4444);
	}
	
	public void testStackArray(){
		while(!stk.isEmpty()){
			System.out.println(stk.pop());
		}
	}
}
