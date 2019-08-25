package pers.tavish.solution.medium;

/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

for more information: https://leetcode.com/problems/maximum-product-subarray/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
            min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = {2, 3, -2, -1, -5, -2};
        Assert.assertEquals(120, maxProduct(nums));
    }
}
