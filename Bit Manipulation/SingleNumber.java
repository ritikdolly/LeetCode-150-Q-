// ? https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=top-interview-150

//! 136. Single Number
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

public class SingleNumber {
    // class Solution {
    // public int singleNumber(int[] nums) {
    // int n=nums.length;
    // if(n == 1){
    // return nums[0];
    // }
    // Arrays.sort(nums);

    // for(int i=0;i<n-1;i+=2){
    // if(nums[i] != nums[i+1]){
    // return nums[i];
    // }
    // }
    // return nums[n-1];
    // }
    // }

    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
    public static void main(String args[]) {
        Solution sol = new SingleNumber().new Solution();
        int[] nums = { 2, 2, 1 }; // Example input
        int result = sol.singleNumber(nums);
        System.out.println("The single number is: " + result);
    }
}
