package q003;

import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        for (int end = 0, head = 0; end < s.length(); end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(head++));
            }

            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }

}
