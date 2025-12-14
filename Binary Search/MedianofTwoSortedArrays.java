// ? https://leetcode.com/problems/median-of-two-sorted-arrays/?envType=study-plan-v2&envId=top-interview-150

//! 4. Median of Two Sorted Arrays
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
import java.util.Arrays;

public class MedianofTwoSortedArrays {

    // using merge sort without extra space and finding median approach 1
    // class Solution {
    //     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //         int n = nums1.length;
    //         int m = nums2.length;
    //         int val1 = 0;
    //         int val2 = 0;
    //         int mid1 = (m + n) / 2;
    //         int mid2 = ((m + n) / 2) - 1;
    //         int k = 0, i = 0, j = 0;

    //         while (i < n && j < m) {
    //             if (nums1[i] <= nums2[j]) {
    //                 if (k == mid1) {
    //                     val1 = nums1[i];
    //                 }
    //                 if (k == mid2) {
    //                     val2 = nums1[i];
    //                 }
    //                 i++;
    //             } else {
    //                 if (k == mid1) {
    //                     val1 = nums2[j];
    //                 }
    //                 if (k == mid2) {
    //                     val2 = nums2[j];
    //                 }
    //                 j++;
    //             }
    //             k++;
    //         }
    //         while (i < n) {
    //             if (k == mid1) {
    //                 val1 = nums1[i];
    //             }
    //             if (k == mid2) {
    //                 val2 = nums1[i];
    //             }
    //             i++;
    //             k++;
    //         }
    //         while (j < m) {
    //             if (k == mid1) {
    //                 val1 = nums2[j];
    //             }
    //             if (k == mid2) {
    //                 val2 = nums2[j];
    //             }
    //             j++;
    //             k++;
    //         }

    //         if ((m + n) % 2 != 0) {
    //             return val1;
    //         }
    //         return (val1 + val2) / 2.0;

    //     }
    // }

    // using sorted array approach 2
    // class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // int n = nums1.length;
    // int m = nums2.length;
    // int[] merged = new int[n + m];
    // int k = 0;
    // for (int i = 0; i < n; i++) {
    // merged[k++] = nums1[i];
    // }
    // for (int i = 0; i < m; i++) {
    // merged[k++] = nums2[i];
    // }
    // Arrays.sort(merged);
    // int total = merged.length;
    // if (total % 2 == 1) {
    // return (double) merged[total / 2];
    // } else {
    // return (double) (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
    // }
    // }
    // }

    // without using sorted array approach 2
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] merged = new int[n + m];
            int k = 0, i = 0, j = 0;

            while (i < n && j < m) {
                if (nums1[i] <= nums2[j]) {
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            }
            while (i < n) {
                merged[k++] = nums1[i++];
            }
            while (j < m) {
                merged[k++] = nums2[j++];
            }

            int mid = (m + n) / 2;
            // check even length
            if ((m + n) % 2 == 0) {
                return (merged[mid] + merged[mid - 1]) / 2.0;
            } else {
                return merged[mid];
            }

        }

    }
    public static void main(String[] args) {
        Solution sol = new MedianofTwoSortedArrays().new Solution();
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        double median = sol.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median); // Output: 2.0
    }
}
