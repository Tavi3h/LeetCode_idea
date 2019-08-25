package pers.tavish.solution.medium;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

for more information: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        if (s == null) {
            return 0;
        }

        int length = s.length();
        Set<Character> set = new HashSet<>();
        int answer = 0, left = 0, right = 0;
        while (left < length && right < length) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                answer = Math.max(answer, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return answer;
    }

    @Test
    public void testCase() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
