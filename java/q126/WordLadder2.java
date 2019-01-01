package q126;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Number   126
 * Title    Word Ladder II
 * Tag      Array, String, Backtracking, BFS
 * Link     https://leetcode.com/problems/word-ladder-ii/
 * Diff     Hard
 */
public class WordLadder2 {

    private String endWord;
    private Map<String, Set<String>> neighbors;
    private HashMap<String, Integer> distances = new HashMap<>();
    private Queue<String> queue = new ArrayDeque<>();
    private List<List<String>> paths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }

        this.endWord = endWord;

        wordList.add(beginWord);
        buildNeighbors(wordList);

        distances.put(beginWord, 0);
        queue.offer(beginWord);

        if (foundEndWordDistance()) {
            findPathsFrom(beginWord, new ArrayList<>());
            return paths;
        }

        return Collections.emptyList();
    }

    private boolean foundEndWordDistance() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                int currentDis = distances.get(currentWord);
                for (String neighbor : neighbors.get(currentWord)) {
                    if (!distances.containsKey(neighbor)) {
                        distances.put(neighbor, currentDis + 1);
                    }
                    if (neighbor.equals(endWord)) {
                        return true;
                    }
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    private void findPathsFrom(String currentWord, List<String> prevPath) {
        List<String> currentPath = new ArrayList<>(prevPath);
        currentPath.add(currentWord);

        if (endWord.equals(currentWord)) {
            paths.add(currentPath);
        } else {
            for (String nextWord : neighbors.get(currentWord)) {
                if (distances.get(currentWord) + 1 == distances.get(nextWord)) {
                    findPathsFrom(nextWord, new ArrayList<>(currentPath));
                }
            }
        }
    }

    private void buildNeighbors(List<String> wordList) {
        neighbors = wordList.stream().collect(Collectors.toMap(x -> x, x -> new HashSet<>()));

        for (String w1 : wordList) {
            for (String w2 : wordList) {
                if (!neighbors.get(w1).contains(w2)
                        && !neighbors.get(w2).contains(w1)
                        && isNeighbor(w1, w2)) {
                    neighbors.get(w1).add(w2);
                    neighbors.get(w2).add(w1);
                }
            }
        }
    }

    private boolean isNeighbor(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            diff += a.charAt(i) == b.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }

}
