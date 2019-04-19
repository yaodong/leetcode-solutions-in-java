package leetcode.Q3_LongestSubstringNoRepeat;

import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int result = 0;
        HashSet<Character> memory = new HashSet<>();

        for (int p1 = 0, p2 = 0; p2 < s.length(); p2++) {

            while (memory.contains(s.charAt(p2))) {
                memory.remove(s.charAt(p1));
                p1++;
            }

            memory.add(s.charAt(p2));

            result = Math.max(result, memory.size());
        }

        return result;
    }

}
