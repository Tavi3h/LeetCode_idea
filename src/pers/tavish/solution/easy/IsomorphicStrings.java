package pers.tavish.solution.easy;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true

Note:

You may assume both s and t have the same length.

for more information:
 */

import org.junit.Assert;
import org.junit.Test;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] hashS = new int[256], hashT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i), ti = t.charAt(i);
            if (hashS[si] != hashT[ti]) {
                return false;
            }
            hashS[si] = i + 1;
            hashT[ti] = i + 1;
        }
        return true;
    }

    @Test
    public void testCase() {
        Assert.assertTrue(isIsomorphic("egg", "add"));
        Assert.assertFalse(isIsomorphic("foo", "bar"));
        Assert.assertTrue(isIsomorphic("paper", "title"));
    }
}
