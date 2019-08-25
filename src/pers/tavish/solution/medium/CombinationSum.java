package pers.tavish.solution.medium;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    - All numbers (including target) will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

for more information: https://leetcode.com/problems/combination-sum/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates != null && candidates.length != 0) {
            combinationSum(candidates, target, res, new ArrayList<>(), 0);
        }
        return res;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int idx) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], res, list, i);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        int[] candidates = {2, 3, 5};
        System.out.println(combinationSum(candidates, 8));
    }
}
