package pers.tavish.solution.medium;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> list, int level, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
