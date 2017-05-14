package net.weever.leetcode;

public class BitSolution {

  public int hammingDistance(int x, int y) {
    int z = x^y;
    // Integer.bitCount(z);
    int count = 0;
    while (z > 0){
      if ((z&1) == 1)
        count++;
      z >>= 1;
    }
    return count;
  }

  //371. Sum of Two Integers
  public int getSum(int a, int b) {
    if(b == 0)
      return a;
    int carry = a&b;
    a = a^b;
    b = carry << 1;
    return getSum(a, b);
  }


}
