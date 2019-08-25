package pers.tavish.solution.medium;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

for more information: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int left = idx, right = idx;
        while (left >= 0) {
            if (nums[left] == nums[idx]) {
                left--;
            } else {
                break;
            }
        }

        while (right < nums.length) {
            if (nums[right] == nums[idx]) {
                right++;
            } else {
                break;
            }
        }

        return new int[]{++left, --right};
    }
}
