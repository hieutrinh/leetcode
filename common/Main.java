package leetcode.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.amazon.medium.word_ladder.WordLadder_Hieu_Solution;

public class Main {

    public static void main(String[] args) {
        boolean b2 = true;
        boolean b1 = false;
        boolean b3 = true;
        boolean b4 = false;
        b4 |= b4;
        b4 |= b3;
        b4 |= b4;
        b4 |= b3;
        b4 |= b1;
        System.out.println(b4);
        List<String> list = Collections.singletonList("");
        System.out.println(list.get(0));
    }
    
    public static void main1(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder_Hieu_Solution wl = new WordLadder_Hieu_Solution();
        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
    
    public static void main5(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        String beginWord = "hit";
        String endWord = "catsanddog";

        WordLadder_Hieu_Solution wl = new WordLadder_Hieu_Solution();
        System.out.println(wl.ladderLength(beginWord, endWord, wordList));
    }
    
    public static void main3(String[] args) {
        Set<String> wordList = new HashSet<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder_Hieu_Solution solution = new WordLadder_Hieu_Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }

}
