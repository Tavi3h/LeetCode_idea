package pers.tavish.solution.medium;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

for more information: https://leetcode.com/problems/surrounded-regions/description/
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '$';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
}
