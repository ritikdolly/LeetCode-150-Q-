// ? https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

// ! 80. Remove Duplicates from Sorted Array II
// Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
// Return k after placing the final result in the first k slots of nums.
// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
// Custom Judge:
// The judge will test your solution with the following code:
// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length
// int k = removeDuplicates(nums); // Calls your implementation
// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

// Example 1:
// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3,_]

public class RemoveDuplicatesfromSortedArrayII {

    // method 1 using two pointers
    // class Solution {
    //     public int removeDuplicates(int[] nums) {
    //         if (nums.length <= 2) {
    //             return nums.length;
    //         }

    //         int index = 2;
    //         for (int i = 2; i < nums.length; i++) {
    //             if (nums[i] != nums[index - 2]) {
    //                 nums[index] = nums[i];
    //                 index++;
    //             }
    //         }
    //         return index;
    //     }
    // }

    //method 2 optimized
    class Solution {
    public int removeDuplicates(int[] nums) {
    int i = 2;
    for (int j = 2; j < nums.length; j++) {
    if (nums[j] != nums[i - 2]) {
    nums[i++] = nums[j];
    }
    }
    return i;
    }
    }

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesfromSortedArrayII().new Solution();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = solution.removeDuplicates(nums);
        System.out.println("Length after removing duplicates: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}