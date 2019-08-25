package pers.tavish.solution.easy;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

for more information: https://leetcode.com/problems/pascals-triangle/description/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        } else {
            res.add(Arrays.asList(new Integer[] { 1 }));
        }
        for (int i = 1; i < numRows; ++i) {
            LinkedList<Integer> list = new LinkedList<>();
            List<Integer> pre = res.getLast();
            for (int j = 0; j < pre.size() - 1; j++) {
                list.add(pre.get(j) + pre.get(j + 1));
            }
            list.addFirst(1);
            list.addLast(1);
            res.add(list);
        }
        return res;
    }
}
