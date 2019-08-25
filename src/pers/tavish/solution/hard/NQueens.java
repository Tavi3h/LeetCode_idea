package pers.tavish.solution.hard;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

for more information: https://leetcode.com/problems/n-queens/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] table = new char[n][n];
        for (char[] cs : table) {
            Arrays.fill(cs, '.');
        }
        solveNQueens(res, table, 0);
        return res;
    }

    private void solveNQueens(List<List<String>> res, char[][] table, int row) {
        if (row == table.length) {
            List<String> list = new ArrayList<>();
            for (char[] cs : table) {
                list.add(String.valueOf(cs));
            }
            res.add(list);
        } else {
            for (int col = 0; col < table.length; col++) {
                if (isValid(table, row, col)) {
                    table[row][col] = 'Q';
                    solveNQueens(res, table, row + 1);
                    table[row][col] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] table, int row, int col) {

        // check col
        for (int i = row - 1; i >= 0; i--) {
            if (table[i][col] == 'Q') {
                return false;
            }
        }

        // check diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j <= table.length - 1; i--, j++) {
            if (table[i][j] == 'Q') {
                return false;
            }
        }

        // check back-diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (table[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testCase() {
        System.out.println(solveNQueens(4));
    }
}
