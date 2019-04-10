package leetcode.q005;

public class Solution {


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();

        // mem[start][end]: start at i, end at j, is palindrome or not
        boolean[][] mem = new boolean[n][n];

        // start: the start position of a longest palindrome string
        int max_start = 0;

        // end: the end position of a longest palindrome string
        int max_end = 0;

        // base case: 1 character
        for (int i = 0; i < n; i++) {
            mem[i][i] = true;
        }

        // base case: 2 character
        for (int i = 0; i < n - 1; i++) {
            mem[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (mem[i][i + 1]) {
                max_start = i;
                max_end = i + 1;
            }
        }

        // from size 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                mem[i][j] = mem[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (mem[i][j]) {
                    max_start = i;
                    max_end = j;
                }
            }
        }

        return s.substring(max_start, max_end + 1);
    }

}
