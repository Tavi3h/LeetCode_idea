package pers.tavish.solution.medium;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

for more information: https://leetcode.com/problems/combinations/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void combine(List<List<Integer>> res, List<Integer> list, int level, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = level; i <= n; i++) {
                list.add(i);
                combine(res, list, i + 1, n, k);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(combine(4, 2));
    }
}
