package net.weever.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

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

  /**
   * 345. Reverse Vowels of a String
   * Write a function that takes a string as input and reverse only the vowels of a string.
   * Example 1:
   * Given s = "hello", return "holle".
   * Example 2:
   * Given s = "leetcode", return "leotcede".
   * Note:
   * The vowels does not include the letter "y".
   */
  public String reverseVowels(String s) {
    if(s == null || s.length() <= 1)
      return s;
    String vowels = "aeiouAEIOU";
    char[] ss = s.toCharArray();
    int l = 0, r = ss.length -1;
    while(l < r){
      if(l<r && !vowels.contains(ss[l]+"")){
        l++;
        continue;
      }
      if(l<r && !vowels.contains(ss[r]+"")){
        r--;
        continue;
      }
        Character c = ss[l];
        ss[l] = ss[r];
        ss[r] = c;
        l++;r--;
    }
    return new String(ss);
  }
}
