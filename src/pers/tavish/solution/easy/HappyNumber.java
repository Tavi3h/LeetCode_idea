package pers.tavish.solution.easy;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

for more information: https://leetcode.com/problems/happy-number/description/
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    public boolean isHappy(int n, Set<Integer> set) {

        if (n == 1) {
            return true;
        }

        int res = 0;
        while (n > 0) {
            int i = n % 10;
            res += Math.pow(i, 2);
            n /= 10;
        }
        if (!set.contains(res)) {
            set.add(res);
        } else {
            return false;
        }
        return isHappy(res, set);
    }
}
