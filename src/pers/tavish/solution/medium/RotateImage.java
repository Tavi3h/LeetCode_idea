package pers.tavish.solution.medium;

/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

for more information: https://leetcode.com/problems/rotate-image/description/
 */

import org.junit.Test;

import java.util.Arrays;

public class RotateImage {

    // recursively
    public void rotate(int[][] matrix) {
        rotate(matrix, matrix.length - 1, 0);
    }

    private void rotate(int[][] matrix, int len, int idx) {

        if (len < idx) {
            return;
        }

        for (int i = idx; i < len; i++) {
            int tmp = matrix[idx][i];
            matrix[idx][i] = matrix[matrix.length - 1 - i][idx];
            matrix[matrix.length - 1 - i][idx] = matrix[matrix.length - 1 - idx][matrix.length - 1 - i];
            matrix[matrix.length - 1 - idx][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - idx];
            matrix[i][matrix.length - 1 - idx] = tmp;
        }
        rotate(matrix, len - 1, idx + 1);
    }

    /*
    // iteratively
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i <= (length - 1) / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                int a = matrix[i][j], b = matrix[j][length - 1 - i], c = matrix[length - 1 - i][length - 1 - j],
                        d = matrix[length - 1 - j][i];
                matrix[j][length - 1 - i] = a;
                matrix[length - 1 - i][length - 1 - j] = b;
                matrix[length - 1 - j][i] = c;
                matrix[i][j] = d;
            }
        }
    }
     */

    @Test
    public void testCase() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix);

        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
    }
}
