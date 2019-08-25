package pers.tavish.solution.medium;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

for more information: https://leetcode.com/problems/subsets-ii/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void subsetsWithDup(List<List<Integer>> res, List<Integer> list, int level, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            if (i > level && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDup(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 2, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
