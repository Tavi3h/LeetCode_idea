package pers.tavish.solution.medium;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

for more information: https://leetcode.com/problems/merge-intervals/description/
 */

import org.junit.Test;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));

        LinkedList<int[]> list = new LinkedList<>();

        list.addLast(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] last = list.removeLast();
            if (last[1] >= interval[0]) {
                int begin = last[0], end = Math.max(last[1], interval[1]);
                list.addLast(new int[]{begin, end});
            } else {
                list.addLast(last);
                list.addLast(interval);
            }
        }

        return list.toArray(new int [list.size()][]);
    }

    @Test
    public void testCase() {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {4, 8},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[][] res = merge(intervals);

        for (int i = 0; i < res.length; i++) {
            int[] re = res[i];
            System.out.println(Arrays.toString(re));
        }
    }
}
