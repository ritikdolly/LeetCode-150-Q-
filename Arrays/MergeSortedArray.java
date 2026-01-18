//? https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

// ! 88. Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

// Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]


public class MergeSortedArray {
    class Solution {
        public void merge(int[] num1, int m, int[] num2, int n) {
            int i = m - 1;
            int j = n - 1;
            int idx = m + n - 1;

            while (i >= 0 && j >= 0) {
                if (num1[i] <= num2[j]) {
                    num1[idx--] = num2[j--];
                } else {
                    num1[idx--] = num1[i--];
                }
            }
            while (j >= 0) {
                num1[idx--] = num2[j--];
            }

        }
    }
}
