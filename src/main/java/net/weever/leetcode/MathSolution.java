package net.weever.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.ToIntBiFunction;

public class MathSolution {

  /**
   * 258. Add Digits
   * https://en.wikipedia.org/wiki/Digital_root
   */
  public int addDigits(int num) {
    return num == 0 ? 0 : (num%9 == 0 ? 9 : num% 9);
  }

  /**
   * 507. Perfect Number
   * Input: 28
   * Output: True
   * Explanation: 28 = 1 + 2 + 4 + 7 + 14
   */
  public boolean checkPerfectNumber(int num) {
    if(num == 1)
      return false;
    int sum = 1;
    for( int i = 2 ; i <= Math.sqrt(num); i++){
      if(num%i == 0)
        sum += i + num/i;
    }
    return sum == num;
  }

  public static void main(String[] args){
    long start = System.currentTimeMillis();
    System.out.println(new MathSolution().checkPerfectNumber(28));
    System.out.println(new MathSolution().divide(-2147483648, -1));
    System.out.println("Response time: " + (System.currentTimeMillis() - start));
  }


  public int divide(int dividend, int divisor) {
    int sign = 1;
    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
      sign = -1;
    if (divisor == 0) return Integer.MAX_VALUE;


    long up = Math.abs((long) dividend);
    long down = Math.abs((long) divisor);

    if (up < down) return 0;

    long ans = dividehelper(up, down);

    if (ans > Integer.MAX_VALUE) {
      return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

    }
    return (int) (sign * ans);
  }

  public long dividehelper(long up, long down){
    if(up < down)
      return 0;
    long sum = down;
    long multi = 1;
    while((sum+sum) <= up){
      sum +=sum;
      multi+=multi;
    }

    return multi + dividehelper(up - sum, down);
  }


  public int base26toBase10(String s) {
    if (s == null)
      return 0;
    int sum = 0;
    for (int i=0; i < s.length(); i++) {
      int n = s.charAt(i) - 'A' + 1;
      sum += Math.pow(26, s.length()-i-1) * n;
    }
    return sum;
  }

  public int evalRPN(String[] tokens) {
    Map<String, ToIntBiFunction<Integer, Integer>> map = new HashMap<>();
    map.put("*", (a, b) -> a*b);
    map.put("/", (a, b) -> a/b);
    map.put("+", (a, b) -> a+b);
    map.put("-", (a, b) -> a-b);

    Stack<Integer> operand = new Stack<>();

    for(String s: tokens) {
      if(s.length()==1 && map.containsKey(s)) {
        ToIntBiFunction<Integer, Integer> func = map.get(s);
        int a = operand.pop();
        int b = operand.pop();
        int result = func.applyAsInt(a, b);
        operand.push(result);
      } else {
        operand.push(Integer.valueOf(s));
      }
    }
    return operand.pop();
  }

    // 3/2 = 1. 3+2*3 =
    public int calculate(String expression) {
      Stack<Integer> operand = new Stack<>();
      Stack<Character> operator = new Stack<>();
      int i = 0;

      while(i< expression.length()) {
        if (Character.isDigit(expression.charAt(i))) {
          int sum = 0;
          while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
            sum = sum * 10 + expression.charAt(i++) - '0';
          }
          operand.push(sum);
        } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
          operator.push(expression.charAt(i++));
        } else {
          int a = operand.pop();
          int b = 0;
          Character c = expression.charAt(i++);
          while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
            b = b * 10 + expression.charAt(i++) - '0';
          }
          if (c == '*') {
            operand.push(a*b);
          } else {
            operand.push(a/b);
          }
        }
      }

      while (operator.size() != 0) {
        int a = operand.pop();
        int b = operand.pop();
        Character c = operator.pop();
        if (c == '+') {
          operand.push(a+b);
        } else {
          operand.push(b-a);
        }
      }

      return operand.pop();
    }
}
