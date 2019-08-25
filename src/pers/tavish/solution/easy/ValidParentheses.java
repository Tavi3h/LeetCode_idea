package pers.tavish.solution.easy;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    - Open brackets must be closed by the same type of brackets.
    - Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

for more information: https://leetcode.com/problems/valid-parentheses/description/
 */

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char t = stack.pop();
                    if ((c == '}' && t != '{') || (c == ')' && t != '(') || (c == ']' && t != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testCase() {
        Assert.assertEquals(true, isValid("()"));
        Assert.assertEquals(true, isValid("()[]{}"));
        Assert.assertEquals(false, isValid("(]"));
        Assert.assertEquals(false, isValid("([)]"));
        Assert.assertEquals(true, isValid("{[]}"));
        Assert.assertEquals(false, isValid("{"));
        Assert.assertEquals(false, isValid("}"));
    }
}
