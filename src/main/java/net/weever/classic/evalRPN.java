package net.weever.classic;

import java.util.Stack;

public class evalRPN {
	
	public static int result(String[] token){
		
		Stack<String> stack = new Stack<String>();
		String oprator ="+-*/";
		
		for(String str : token){
			if(!oprator.contains(str)){
				stack.push(str);
			}else{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int c = 0;
				switch(str){
				case "+": c=b+a; break;
				case "-": c=b-a; break;
				case "*": c=b*a; break;
				case "/": c=b/a; break;
				}
				stack.push(String.valueOf(c));
			}
		}
		
		return Integer.valueOf(stack.pop());
	}
}
