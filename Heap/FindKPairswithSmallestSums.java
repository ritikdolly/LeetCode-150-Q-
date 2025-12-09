//? https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150

//! 373. Find K Pairs with Smallest Sums
// You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
// Define a pair (u, v) which consists of one element from the first array and one element from the second array.
// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

// Example 1:
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]

import java.util.*;

public class FindKPairswithSmallestSums {

    // ? using brute-force with min-heap it show memory limit exceeded
    // class Solution {
    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    // PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) -
    // (b[0] + b[1]));

    // for (int i = 0; i < nums1.length; i++) {
    // for (int j = 0; j < nums2.length; j++) {
    // heap.offer(new int[] { nums1[i], nums2[j] });
    // }
    // }

    // List<List<Integer>> res = new ArrayList<>();

    // while (k-- > 0 && !heap.isEmpty()) {
    // int[] p = heap.poll();
    // res.add(Arrays.asList(p[0], p[1]));
    // }

    // return res;
    // }
    // }

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0 || k == 0)
                return res;

            PriorityQueue<int[]> heap = new PriorityQueue<>(
                    (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

            // Start with pairs (nums1[i], nums2[0])
            for (int i = 0; i < Math.min(nums1.length, k); i++) {
                heap.offer(new int[] { i, 0 });
            }

            while (k-- > 0 && !heap.isEmpty()) {
                int[] pos = heap.poll();
                int i = pos[0], j = pos[1];

                res.add(Arrays.asList(nums1[i], nums2[j]));

                if (j + 1 < nums2.length) {
                    heap.offer(new int[] { i, j + 1 });
                }
            }

            return res;
        }
    }
    public static void main(String[] args) {
        Solution solution = new FindKPairswithSmallestSums().new Solution();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result); // Output: [[1,2],[1,4],[1,6]]
    }
}
