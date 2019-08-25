package pers.tavish.solution.hard;

/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

    - s could be empty and contains only lowercase letters a-z.
    - p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

for more information: https://leetcode.com/problems/regular-expression-matching/description/
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        if (s == null && p == null) return true;
        if (s == null || p == null) return false;

        char[] sa = s.toCharArray(), pa = p.toCharArray();

        // matched[i][j]表示是否成功匹配到p的第i个（不含）和s的第j个（不含）
        boolean[][] matched = new boolean[pa.length + 1][sa.length + 1];
        matched[0][0] = true;
        for (int i = 1; i <= pa.length; i++) {
            //第i个p是否与第0个s匹配，只有当上一个p是*且上一个匹配为true
            matched[i][0] = pa[i - 1] == '*' && matched[i - 2][0];
            for (int j = 1; j <= sa.length; j++) {
                if (pa[i - 1] == '.') {
                    //当p为.，必须要s上一个字符和p上一个字符匹配
                    matched[i][j] = matched[i - 1][j - 1];
                } else if (pa[i - 1] == sa[j - 1]) {
                    //当p和s相同，必须要s上一个字符和p上一个字符匹配
                    matched[i][j] = matched[i - 1][j - 1];
                } else if (pa[i - 1] == '*') {
                    //当p为*
                    if (pa[i - 2] != sa[j - 1] && pa[i - 2] != '.') {
                        matched[i][j] = matched[i - 2][j];
                    } else {
                        matched[i][j] = matched[i][j - 1] || matched[i - 1][j] || matched[i - 2][j];
                    }
                }
            }
        }
        return matched[pa.length][sa.length];
    }
}
