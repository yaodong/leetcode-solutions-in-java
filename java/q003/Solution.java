package q003;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> seen = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = s.length();

        while (i < n && j < n) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                seen.remove(s.charAt(i++));
            }
        }

        return ans;
    }

}
