// ? https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

// ! 34. Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

public class FindFirstLastPositionofEleinSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int[] res = { -1, -1 };

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    int start = mid;
                    while (start - 1 >= 0 && nums[start - 1] == target) {
                        start--;
                    }
                    res[0] = start;

                    int end = mid;
                    while (end + 1 < nums.length && nums[end + 1] == target) {
                        end++;
                    }
                    res[1] = end;
                    return res;
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution sol = new FindFirstLastPositionofEleinSortedArray().new Solution();
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] result = sol.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]
    }
}
