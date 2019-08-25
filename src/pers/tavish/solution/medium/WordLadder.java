package pers.tavish.solution.medium;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    - Only one letter can be changed at a time.
    - Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    - Return 0 if there is no such transformation sequence.
    - All words have the same length.
    - All words contain only lowercase alphabetic characters.
    - You may assume no duplicates in the word list.
    - You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int dist = 1;

        while (!queue.contains(endWord)) {
            int size = queue.size();
            for (int n = 0; n < size; ++n) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); ++i) {
                    char[] chars = word.toCharArray();
                    for (char j = 'a'; j < 'z' + 1; ++j) {
                        chars[i] = j;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            ++dist;
            if (queue.isEmpty()) {
                return 0;
            }
        }
        return dist;
    }
}
