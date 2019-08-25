package pers.tavish.solution.hard;

/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4

Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

for more information: https://leetcode.com/problems/max-points-on-a-line/description/
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        } else if (points.length <= 2) {
            return points.length;
        }
        int solution = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // find max number of points that lie on same line, starting at points[i]
            Map<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0) {
                    samePoint++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String slope = y + "/" + x; // key for HashMap
                map.merge(slope, 1, Integer::sum);
            }

            int linesMax = 0;
            for (int value : map.values()) {
                linesMax = Math.max(linesMax, value);
            }

            solution = Math.max(solution, 1 + linesMax + samePoint);
        }
        return solution;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
