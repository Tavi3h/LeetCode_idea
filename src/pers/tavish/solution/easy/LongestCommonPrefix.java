package pers.tavish.solution.easy;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

    - All given inputs are in lowercase letters a-z.

for more information: https://leetcode.com/problems/longest-common-prefix/description/
 */

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        return strs == null || strs.length == 0 ? "" : lcp(strs, 0, strs.length - 1);
    }

    private String lcp(String[] strs, int lo, int hi) {
        if (lo == hi) {
            return strs[lo];
        }
        int mid = lo + (hi - lo >>> 1);
        return lcp(lcp(strs, lo, mid), lcp(strs, mid + 1, hi));

    }

    private String lcp(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, length);
    }

    @Test
    public void testCase() {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        Assert.assertEquals("fl", longestCommonPrefix(strs1));
        Assert.assertEquals("", longestCommonPrefix(strs2));
    }
}
