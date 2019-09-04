package pers.tavish.solution.medium;

/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

for more information: https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 */

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return n;
    }
}
