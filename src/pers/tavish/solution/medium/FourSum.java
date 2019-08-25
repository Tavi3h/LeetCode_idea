package pers.tavish.solution.medium;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

for more information: https://leetcode.com/problems/4sum/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int rest = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[j] + nums[m] + nums[n];
                    if (sum == rest) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m++], nums[n--]));
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (sum > rest) {
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
        }
        return res;
    }

    @Test
    public void testCase() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
