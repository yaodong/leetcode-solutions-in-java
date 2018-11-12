package q014;

/**
 * Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }

            if (pre.length() == 0) {
                break;
            }
        }

        return pre;
    }
}