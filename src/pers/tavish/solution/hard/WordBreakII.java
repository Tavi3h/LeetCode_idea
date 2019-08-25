package pers.tavish.solution.hard;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    - The same word in the dictionary may be reused multiple times in the segmentation.
    - You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

for more information: https://leetcode.com/problems/word-break-ii/description/
 */

import org.junit.Test;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        if (wordBreak(s, new HashSet<>(wordSet))) {
            dfs(s, wordSet, res, "");
        }
        return res;
    }

    public void dfs(String s, Set<String> wordSet, List<String> res, String word) {

        if (s.isEmpty()) {
            res.add(word.substring(0, word.length() - 1));
        } else {
            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i + 1);
                if (wordSet.contains(sub)) {
                    dfs(s.substring(i + 1), wordSet, res, word + sub + " ");
                }
            }
        }
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && hs.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    @Test
    public void testCase() {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak(s, wordDict));
    }
}
