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

}
