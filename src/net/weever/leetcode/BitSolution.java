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


  /*
  190. Reverse Bits
  For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
  return 964176192 (represented in binary as 00111001011110000010100101000000).
   */
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int m = 0;
    for(int i= 0; i<32; i++){
      m += n & 1;
      n >>>=1;
      if(i < 31)
        m <<= 1;
    }
    return m;
  }

}
