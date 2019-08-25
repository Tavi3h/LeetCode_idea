package pers.tavish.solution.medium;

/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

for more information: https://leetcode.com/problems/3sum-closest/description/
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                int curDis = Math.abs(target - sum);
                if (curDis < distance) {
                    distance = curDis;
                    closest = sum;
                }
                if (target - sum > 0) {
                    ++m;
                } else {
                    --n;
                }
            }
        }
        return closest;
    }
}
