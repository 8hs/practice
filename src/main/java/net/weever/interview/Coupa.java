package net.weever.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coupa {

    public void mineSweeper(int m, int n, int x) {
        int[] init = new int[m*n];
        for (int i=0; i< x; i++) {
            init[i] = -1;
        }
        List<Integer> list = Arrays.stream(init)
                                .boxed()
                                .collect(Collectors.toList());
        Collections.shuffle(list);
        int[][] matrix = new int[m][n];
        int index = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++){
                matrix[i][j] = list.get(index++);
            }

        // after shuffle
        print(matrix);
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++){
                if(matrix[i][j] != -1)
                    matrix[i][j] = detectNeighbor(i,j,matrix);
            }
        // detected
        System.out.println("====================");
        print(matrix);
    }

    private int detectNeighbor(int i, int j, int[][] matrix) {
        int count = 0;
        if(i>0 && matrix[i-1][j] == -1)
            count++;
        if(j>0 && matrix[i][j-1] == -1)
            count++;
        if(i<matrix.length-1 && matrix[i+1][j] == -1)
            count++;
        if(j<matrix[0].length-1 && matrix[i][j+1] == -1)
            count++;
        if(i>0 && j>0 && matrix[i-1][j-1] == -1)
            count++;
        if(i<matrix.length-1 && j<matrix[0].length-1 && matrix[i+1][j+1] == -1)
            count++;
        if(i>0 && j<matrix[0].length-1 && matrix[i-1][j+1] == -1)
            count++;
        if(j>0 && i<matrix.length-1 && matrix[i+1][j-1] == -1)
            count++;
        return count;
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
