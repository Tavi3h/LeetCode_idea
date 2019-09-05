package pers.tavish.solution.medium;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

    - The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    - You may assume that there are no duplicate edges in the input prerequisites.

for more information: https://leetcode.com/problems/course-schedule/description/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return false;
        }

        if (prerequisites.length == 0) {
            return true;
        }

        List<List<Integer>> adjLists = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjLists.add(new LinkedList<>());
        }

        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adjLists.get(prerequisite[1]).add(prerequisite[0]);
            ++inDegrees[prerequisite[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int src = queue.poll();
            res.add(src);
            for (int dest : adjLists.get(src)) {
                if (--inDegrees[dest] == 0) {
                    queue.add(dest);
                }
            }
        }

        return res.size() == numCourses;
    }
}
