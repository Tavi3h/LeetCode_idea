package pers.tavish.solution.medium;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:

matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:

matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false

for more information: https://leetcode.com/problems/search-a-2d-matrix/description/
 */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            int midElement = matrix[mid / n][mid % n];
            if (target > midElement) {
                lo = mid + 1;
            } else if (target < midElement) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
