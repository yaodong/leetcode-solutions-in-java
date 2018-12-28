package q004;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void testSolution() {
        int[] arr1 = new int[]{3, 5, 8};
        int[] arr2 = new int[]{1, 4, 5, 7, 9, 10};
        double actual = MedianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2);
        assertEquals(5.0, actual, 0.001);
    }

    @Test
    public void testSolution2() {
        int[] arr1 = new int[]{3,4};
        int[] arr2 = new int[]{1,2};
        double actual = MedianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2);
        assertEquals(2.5, actual, 0.001);
    }

    @Test
    public void testSolution3() {
        int[] arr1 = new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        double actual = MedianOfTwoSortedArrays.findMedianSortedArrays(arr1, arr2);
        assertEquals(2.5, actual, 0.001);
    }
}
