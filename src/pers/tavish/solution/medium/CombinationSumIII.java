package pers.tavish.solution.medium;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

    - All numbers will be positive integers.
    - The solution set must not contain duplicate combinations.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

for more information: https://leetcode.com/problems/combination-sum-iii/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void combinationSum3(List<List<Integer>> res, List<Integer> list, int k, int n, int idx) {
        if (n < 0 || list.size() > k) {
            return;
        } else if (n == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = idx; i < 10; i++) {
                list.add(i);
                combinationSum3(res, list, k, n - i, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(combinationSum3(3, 9));
    }
}
