package q127;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // special cases
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // initialization
        wordList.add(beginWord);

        Map<String, List<String>> neighborMap = makeNeighborMap(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // BFS to find the shortest distance between the begin word and end word
        int depth = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                for (String neighbor : neighborMap.get(curWord)) {

                    if (neighbor.equals(endWord)) {
                        return depth;
                    }

                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return 0;
    }

    private Map<String, List<String>> makeNeighborMap(List<String> wordList) {
        Map<String, List<String>> map = wordList.stream()
                .collect(Collectors.toMap(x -> x, x -> new ArrayList<>()));

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String w1 = wordList.get(i);
                String w2 = wordList.get(j);

                if (isNeighbor(w1, w2)) {
                    map.get(w1).add(w2);
                    map.get(w2).add(w1);
                }
            }
        }

        return map;
    }


    private boolean isNeighbor(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            diff += w1.charAt(i) == w2.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}
