package leetcode.Q4_MedianOfTwoSortedArrays;

public class Solution {

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {

        // let arr1 always be the smaller one
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        // the total number of elements if we merge arr1 and arr2
        int lenSum = arr1.length + arr2.length;
        int lenFrom1, lenFrom2;

        // we need to find out how many elements we need to take from arr1
        // so we set the boundaries for binary search
        int beginIndex = 0, lastIndex = arr1.length - 1;

        // the end condition is that the begin index is
        while (true) {

            lenFrom1 = beginIndex + (lastIndex - beginIndex) / 2 + 1;
            lenFrom2 = lenSum / 2 - lenFrom1;

            double numL1 = lenFrom1 == 0 ? Integer.MIN_VALUE : arr1[lenFrom1 - 1];
            double numR1 = lenFrom1 == arr1.length ? Integer.MAX_VALUE : arr1[lenFrom1];

            double numL2 = lenFrom2 == 0 ? Integer.MIN_VALUE : arr2[lenFrom2 - 1];
            double numR2 = lenFrom2 == arr2.length ? Integer.MAX_VALUE : arr2[lenFrom2];


            // if all left are smaller than all right. we found the right position
            if (numL1 <= numR1 && numL2 <= numR1) {
                if (lenSum % 2 == 0) {
                    return (Math.max(numL1, numL2) + Math.min(numR1, numR2)) / 2;
                } else {
                    return Math.min(numR1, numR2);
                }
            }
            // otherwise, adjust searching range
            else {
                // if left1 > right2, we need less elements from arr1, search in arr1[begin:lenFrom1-1]
                if (numL1 > numR2) {
                    lastIndex = lenFrom1 - 1;
                }

                // if left1 > right2, we need more elements from arr1, search in arr1[lenFrom1:lastIndex]
                else if (numL2 > numR1) {
                    beginIndex = lenFrom1;
                }
            }
        }
    }
}
