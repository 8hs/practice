package net.weever.leetcode;


import net.weever.datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by localadmin on 6/18/17.
 */
public class MatrixSolution {

  public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix == null) return null;
    List<Integer> list = new ArrayList<>();
    int height = matrix.length;
    if(height == 0) return list;
    int length = matrix[0].length;
    if(length == 0) return list;

    int turn = 0;
    while(true){
      //go left
      int h = turn, l = turn;

      int step = length;
      if( step == 0) break;
      while(step-- > 0){
        list.add(matrix[h][l++]);
      }
      l--;
      //go down;
      step = height - 1;
      if(step == 0) break;
      h++;
      while(step-- > 0){
        list.add(matrix[h++][l]);
      }
      h--;
      //go left
      step = length - 1;
      if(step == 0) break;
      l--;
      while(step-- > 0){
        list.add(matrix[h][l--]);
      }
      l++;
      step = height - 2;
      if(step == 0) break;
      h--;
      while(step-- > 0){
        list.add(matrix[h--][l]);
      }
      turn++;
      height -= 2;
      length -= 2;
    }
    return list;
  }

  public List<Interval> merge(List<Interval> intervals) {
    if(intervals == null) return null;
    if(intervals.size() == 0) return intervals;

    intervals.sort((i1,i2) -> Integer.compare(i1.start,i2.start));

    List<Interval> list = new ArrayList<>();
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;

    for(int i = 1; i<intervals.size(); i++){
      Interval interval = intervals.get(i);
      if(interval.start > end){
        list.add(new Interval(start, end));
        start = interval.start;
        end = interval.end;
        continue;
      }
      if(start <= interval.start && interval.end <= end ){
        continue;
      }
      end = interval.end;
    }

    list.add(new Interval(start, end));

    return list;

  }

  public void setZeroes(int[][] matrix) {
    //int[row][column]
    boolean row = false, column = false;
    for(int i = 0; i < matrix.length; i++)
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 0){
          if(i == 0) row = true;
          if(j == 0) column = true;
          matrix[i][0] = matrix[0][j] = 0;
        }
      }

    for(int i = 1; i < matrix.length; i++)
      for(int j = 1; j < matrix[0].length; j++){
        if(matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;
      }

    if(column)
      for(int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;

    if(row)
      for(int j = 0; j < matrix[0].length; j++)
        matrix[0][j] = 0;
  }

  public static void main(String[] args){
    int[][] matrix = {{7,8,3,5,4},{7,8,3,5,4},{7,8,3,5,4},{7,8,3,5,4},{7,8,3,5,4}};
    new MatrixSolution().spiralOrder(matrix);

    matrix = new int[][]{{1, 0, 3}};
    new MatrixSolution().setZeroes(matrix);
  }
}
