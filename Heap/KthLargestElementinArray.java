// ? https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150

// ! 215. Kth Largest Element in an Array
// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?
// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementinArray {

    //? using max-heap
    // class Solution {
    //     public int findKthLargest(int[] nums, int k) {
    //         int n = nums.length;
    //         PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    //         for (int i = 0; i < n; i++) {
    //             maxPQ.offer(nums[i]);
    //         }
    //         int val = 0;
    //         while (k-- > 0) {
    //             val = maxPQ.poll();
    //         }
    //         return val;
    //     }
    // }

    // ? using min-heap
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                heap.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                if (heap.peek() < nums[i]) {
                    heap.poll();
                    heap.add(nums[i]);
                }
            }
            return heap.peek();
        }
    }

    public static void main(String[] args) {
        Solution solution = new KthLargestElementinArray().new Solution();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result); // Output: 5
    }
}
