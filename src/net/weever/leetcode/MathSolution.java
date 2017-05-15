package net.weever.leetcode;

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
    System.out.println("Response time: " + (System.currentTimeMillis() - start));
  }

}
