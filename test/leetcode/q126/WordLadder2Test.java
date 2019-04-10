package leetcode.q126;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WordLadder2Test {

    private WordLadder2 solution;

    @Before
    public void setup() {
        solution = new WordLadder2();
    }

    @Test
    public void testSolution() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        List<List<String>> actual = solution.findLadders(beginWord, endWord, wordList);
        List<List<String>> expected = new ArrayList<>(Arrays.asList(
                Arrays.asList("hit", "hot", "lot", "log", "cog"),
                Arrays.asList("hit", "hot", "dot", "dog", "cog")));

        assertThat(actual, is(expected));
    }

    @Test
    public void testSolutionInvalid() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        List<List<String>> actual = solution.findLadders(beginWord, endWord, wordList);
        List<List<String>> expected = new ArrayList<>();

        assertThat(actual, is(expected));
    }
}
