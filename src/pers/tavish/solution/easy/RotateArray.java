package pers.tavish.solution.easy;

/*

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

for more information: https://leetcode.com/problems/rotate-array/description/
 */

import org.junit.Test;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        if (nums.length < 2 || k < 1 || k % nums.length == 0) {
            return;
        }

        k = k % nums.length;
        int len = nums.length;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int t = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = t;
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
    }
}
