package q005;

public class Solution {


    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        boolean[][] d = new boolean[n][n];

        // base cases
        int[] range = new int[2];
        for (int i = 0; i < n; i++) {
            d[i][i] = true;
            if (i < n - 1) {
                d[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (d[i][i + 1]) {
                    range[0] = i;
                    range[1] = i + 1;
                }
            }
        }

        // from size 3
        for (int size = 3; size <= n; size++) {
            for (int i = 0; i <= n - size; i++) {
                int j = i + size - 1;
                d[i][j] = d[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (d[i][j]) {
                    range[0] = i;
                    range[1] = j;
                }
            }
        }

        return s.substring(range[0], range[1] + 1);
    }

}
