package pers.tavish.solution.easy;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

for more information: https://leetcode.com/problems/length-of-last-word/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--, res++) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return res;
    }

    @Test
    public void testCase() {
        String s = "Hello World";
        Assert.assertEquals(5, lengthOfLastWord(s));
    }
}
