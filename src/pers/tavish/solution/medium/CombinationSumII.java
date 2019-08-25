package pers.tavish.solution.medium;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

for more information: https://leetcode.com/problems/combination-sum-ii/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates != null && candidates.length != 0) {
            Arrays.sort(candidates);
            combinationSum2(candidates, target, res, new ArrayList<Integer>(), 0);
        }
        return res;
    }

    private void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println(combinationSum2(candidates, 5));
    }
}
