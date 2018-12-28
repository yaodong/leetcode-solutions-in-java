package q127;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLadderTest {

    private WordLadder solution;

    @Before
    public void setUp() {
        solution = new WordLadder();
    }

    @Test
    public void testSolution() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        int actual = solution.ladderLength(beginWord, endWord, wordList);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void testSolutionInvalid() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        int actual = solution.ladderLength(beginWord, endWord, wordList);
        int expected = 0;

        assertEquals(expected, actual);
    }

}
