package net.weever.interview;
/*
After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
	['c', 'c', 'x', 't', 'i', 'b'],
	['c', 'c', 'a', 't', 'n', 'i'],
	['a', 'c', 'n', 'n', 't', 't'],
	['t', 'c', 's', 'i', 'p', 't'],
	['a', 'o', 'o', 'o', 'a', 'a'],
	['o', 'a', 'a', 'a', 'o', 'o'],
	['k', 'a', 'i', 'c', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "bit"
word5 = "aoi"
word6 = "ki"
word7 = "aaa"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 1), (1, 1), (2, 1), (3, 1)]
    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
find_word_location(grid1, word3) => [(3, 2)]
find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word
*/

import java.util.ArrayList;
import java.util.List;

public class Karat {

    public static List<int[]> find(char[][] input, String word) {
        if (input == null || word == null || word.length() == 0) {
            return new ArrayList<int[]>();
        }
        for (int i=0; i< input.length; i++)
            for (int j=0; j< input[0].length; j++) {
                if(input[i][j] == word.charAt(0)) {
                    List<int[]> result = new ArrayList<>();
                    dp(input, new int[]{i, j}, word, 0, result);
                }
            }
        return null;
    }

    private static void dp (char[][] input, int[] current, String word, int index, List<int[]> result) {
        int row = current[0];
        int column = current[1];
        if (index == word.length() || input[row][column] != word.charAt(index)) {
            return;
        }
        result.add(new int[]{row, column});
        if(result.size() == word.length()) {
            for (int[] co : result) {
                System.out.println("co is " + co[0] + ";" + co[1]);
            }
        }
        if(column < input[0].length-1) {
            dp(input, new int[]{row, column+1}, word, index+1, result);
        }
        if(row < input.length-1) {
            dp(input, new int[]{row + 1, column}, word, index + 1, result);
        }
        result.remove(result.size() - 1);
    }
}


