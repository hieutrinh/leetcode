package leetcode.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import leetcode.amazon.medium.word_ladder.WordLadder_Hieu_Solution;

public class WordListCommon {
    public static void main1(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder_Hieu_Solution wl = new WordLadder_Hieu_Solution();
        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
    
    public static void main(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        String beginWord = "hit";
        String endWord = "catsanddog";

        WordLadder_Hieu_Solution wl = new WordLadder_Hieu_Solution();
        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
}
