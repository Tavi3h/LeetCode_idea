package pers.tavish.solution.hard;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

for more information: https://leetcode.com/problems/maximum-subarray/description/
 */

public class MaximumSubarray {

    // one-pass
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0], global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    // two-pass
//    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        if (len == 0) {
//            return 0;
//        }
//        int[] dp = new int[len];
//        dp[0] = nums[0];
//        for (int i = 1; i < len; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//        }
//        int res = dp[0];
//        for (int i = 1; i < len; i++) {
//            res = Math.max(res,dp[i]);
//        }
//        return res;
//    }
}
