package pers.tavish.solution.medium;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

for more information: https://leetcode.com/problems/permutations-ii/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null || nums.length != 0) {
            Arrays.sort(nums);
            permuteUnique(nums, res, new ArrayList<>(), new boolean[nums.length]);
        }
        return res;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    permuteUnique(nums, res, list, visited);
                    list.remove(list.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    @Test
    public void testCase() {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
