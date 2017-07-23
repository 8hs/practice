package net.weever.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by localadmin on 6/25/17.
 */
public class BackTracking {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> curr = new ArrayList<>();
    if(s == null || s.length() == 0)
      return result;
    backtrack(result, curr,s,0);
    return result;
  }

  private void backtrack(List<List<String>> result, List<String> curr, String s, int index ){
    if(curr.size() > 0 && index == s.length()){
      result.add(new ArrayList<>(curr));
    }
    for(int i = index; i < s.length(); i++){
      String str = s.substring(index,i+1);
      if(isPalindrome(str)){
        curr.add(s.substring(index,i+1));
        backtrack(result,curr,s,i+1);
        curr.remove(curr.size()-1);
      }
    }

  }

  private boolean isPalindrome(String str){
    return new StringBuilder(str).reverse().toString().equals(str);
  }

  public static void main(String[] args){
    new BackTracking().partition("aab");
  }
}
