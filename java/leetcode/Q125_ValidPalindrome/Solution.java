package leetcode.Q125_ValidPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char leftC = Character.toLowerCase(s.charAt(left));
            char rightC = Character.toLowerCase(s.charAt(right));

            if (isNotAlphaNumeric(leftC)) {
                left++;
            } else if (isNotAlphaNumeric(rightC)) {
                right--;
            } else if (leftC != rightC) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isNotAlphaNumeric(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z');
    }
}
