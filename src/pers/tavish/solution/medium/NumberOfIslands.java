package pers.tavish.solution.medium;

/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

for more information: https://leetcode.com/problems/number-of-islands/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        char c = 'a';
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, c++);
                }
            }
        }
        return c - 'a';
    }

    private void dfs(char[][] grid, int i, int j, char c) {
        grid[i][j] = c;
        int m = grid.length, n = grid[0].length;
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, c);
        }
        if (i < m - 1 && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, c);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1, c);
        }
        if (j < n - 1 && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1, c);
        }
    }

    @Test
    public void testCase() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, numIslands(grid));
    }
}
