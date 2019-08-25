package pers.tavish.solution.hard;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

for more information: https://leetcode.com/problems/insert-interval/description/
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int insertPos = searchPos(intervals, newInterval);

        int[][] newIntervals = new int[intervals.length + 1][];

        newIntervals[insertPos] = newInterval;
        for (int i = 0; i < insertPos; i++) {
            newIntervals[i] = intervals[i];
        }
        for (int i = insertPos + 1; i < newIntervals.length; i++) {
            newIntervals[i] = intervals[i - 1];
        }

        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(newIntervals[0]);
        for (int i = 1; i < newIntervals.length; i++) {
            int[] interval = newIntervals[i];
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

    private int searchPos(int[][] intervals, int[] newInterval) {
        int lo = 0, hi = intervals.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            if (intervals[mid][0] == newInterval[0] && intervals[mid][1] == newInterval[1]) {
                return mid;
            } else if (intervals[mid][0] > newInterval[0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    public void testCase() {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = {4, 8};
        int[][] res = insert(intervals, newInterval);
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }
}
