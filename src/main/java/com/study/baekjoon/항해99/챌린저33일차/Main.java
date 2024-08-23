package com.study.baekjoon.항해99.챌린저33일차;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        List<String> wordList = Arrays.asList(words);

        if (!wordList.contains(target)) {
            return 0;
        }

        Queue<WordNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new WordNode(begin, 0));
        visited.add(begin);

        while (!queue.isEmpty()) {
            WordNode node = queue.poll();
            String word = node.word;
            int level = node.level;

            if (word.equals(target)) {
                return level;
            }

            for (String w : wordList) {
                if (!visited.contains(w) && canTrans(word, w)) {
                    queue.offer(new WordNode(w, level + 1));
                    visited.add(w);
                }
            }
        }

        return 0;
    }

    private boolean canTrans(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    class WordNode {
        private String word;
        private int level;
        WordNode(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}

public class Main {
    private static Solution solution = new Solution();
    public static void main(String[] args) {
        int result = solution.solution("hit", "cog", new String[]{"hot", "dog", "dog", "lot", "log", "cog"});
        System.out.println(result);
    }
}
