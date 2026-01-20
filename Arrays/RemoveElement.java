// ? https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150

// ! 27. Remove Element
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
// Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:
// The judge will test your solution with the following code:
// int[] nums = [...]; // Input array
// int val = ...; // Value to remove
// int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

// int k = removeElement(nums, val); // Calls your implementation
// assert k == expectedNums.length;
// sort(nums, 0, k); // Sort the first k elements of nums
// for (int i = 0; i < actualLength; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

// Example 1:
// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]

public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[k++] = nums[i];
                }
            }
            return k;
        }
    }
    public static void main(String[] args) {
        Solution sol = new RemoveElement().new Solution();
        int[] nums = {3, 2, 2, 3, 4, 5, 3};
        int val = 3;

        int k = sol.removeElement(nums, val);

        // Print the modified array up to the new length k
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
