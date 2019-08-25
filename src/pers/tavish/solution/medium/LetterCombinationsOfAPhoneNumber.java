package pers.tavish.solution.medium;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

for more information: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits != null && !digits.isEmpty()) {
            letterCombinations(digits, res, "", 0);
        }
        return res;
    }

    private void letterCombinations(String digits, List<String> res, String s, int idx) {
        if (idx == digits.length()) {
            res.add(s);
        } else {
            String letters = TABLE[digits.charAt(idx) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                letterCombinations(digits, res, s + letters.charAt(i), idx + 1);
            }
        }
    }

    @Test
    public void testCase() {
        System.out.println(letterCombinations("23"));
    }
}
