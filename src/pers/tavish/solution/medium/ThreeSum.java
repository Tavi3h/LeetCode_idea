package pers.tavish.solution.medium;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

for more information: https://leetcode.com/problems/3sum/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[m++], nums[n--]));
                    while (m < n && nums[m] == nums[m - 1]) {
                        m++;
                    }
                    while (m < n && nums[n] == nums[n + 1]) {
                        n--;
                    }
                } else if (sum > 0) {
                    n--;
                    while (m < n && nums[n] == nums[n + 1]) {
                        n--;
                    }
                } else {
                    m++;
                    while (m < n && nums[m] == nums[m - 1]) {
                        m++;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = {0 ,0,0};
        System.out.println(threeSum(nums));
    }
}
