package pers.tavish.solution.easy;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

for more information: https://leetcode.com/problems/reverse-integer/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class ReverseInteger {
    public int reverse(int x) {
        String s = "";
        try {
            if (x >= 0) {
                s = new StringBuilder(x + "").reverse().toString();
                return Integer.parseInt(s);
            } else {
                s = new StringBuilder(-x + "").reverse().toString();
                return -Integer.parseInt(s);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Test
    public void testCase() {
        Assert.assertEquals(21, reverse(120));
    }
}
