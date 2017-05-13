package net.weever.leetcode;

public class StringSolution {

  //383. Ransom Note
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] abc = new int[26];
    for(char c: magazine.toCharArray()) abc[c-'a']++;
    for(char c: ransomNote.toCharArray()) {
      if(--abc[c-'a'] < 0)
        return false;
    }
    return true;
  }

  //521. Longest Uncommon Subsequence I
  //what's the meaning of this question???
  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }

  //171. Excel Sheet Column Number
  public int titleToNumber(String s) {
    int count = 0;
    for(char c: s.toCharArray()){
      count = count*26 + (c-'A'+1);
    }
    return count;
  }



}
