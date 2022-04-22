package net.weever.datastructure;

import java.util.Stack;

public class StringProcess {
	
	public static int longestValidParentheses(String s){
		if(s == null || s.length()<2){
			return 0;
		}
		char[] c = s.toCharArray();
		int last = -1;
		int maxLen = 0;
		Stack<Integer> stk = new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(c[i] == '('){
				stk.push(i);
			}else{
				if(stk.isEmpty()){
					last = i;
				}else{
					stk.pop();
					if(stk.isEmpty()){
						maxLen = Math.max(i-last, maxLen);
					}else{
						maxLen = Math.max(i-stk.peek(), maxLen);
					}
				}
			}
		}
		return maxLen;
	}
}
