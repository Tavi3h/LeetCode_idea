package pers.tavish.solution.medium;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

for more information: https://leetcode.com/problems/generate-parentheses/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n > 0) {
            generateParenthesis(res, "", n, n);
        }
        return res;
    }

    private void generateParenthesis(List<String> res, String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
        } else {
            if (left > 0) {
                generateParenthesis(res, s + "(", left - 1, right);
            }
            if (right > left) {
                generateParenthesis(res, s + ")", left, right - 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(generateParenthesis(3));
    }
}
