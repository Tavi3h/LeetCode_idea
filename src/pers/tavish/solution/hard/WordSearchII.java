package pers.tavish.solution.hard;

/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

    - All inputs are consist of lowercase letters a-z.
    - The values of words are distinct.

for more information: https://leetcode.com/problems/word-search-ii/description/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    private class Trie {

        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }

        void add(String word) {
            Trie trie = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (trie.children[idx] == null) {
                    trie.children[idx] = new Trie();
                }
                trie = trie.children[idx];
            }
            trie.isWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie root = new Trie();
        for (String s : words) {
            root.add(s);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                dfs(board, isVisited, root, res, i, j, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] isVisited, Trie trie, Set<String> res, int i, int j, String str) {
        if (trie.isWord) {
            res.add(str);
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisited[i][j]
                || trie.children[board[i][j] - 'a'] == null) {
            return;
        }

        isVisited[i][j] = true;
        Trie t = trie.children[board[i][j] - 'a'];
        str += board[i][j];
        dfs(board, isVisited, t, res, i - 1, j, str); // ⬆
        dfs(board, isVisited, t, res, i, j - 1, str); // ←
        dfs(board, isVisited, t, res, i + 1, j, str); // ⬇
        dfs(board, isVisited, t, res, i, j + 1, str); // →
        isVisited[i][j] = false;
    }
}
