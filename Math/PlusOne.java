// ? https://leetcode.com/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150

// ! Title: Plus One
// Description: You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
// Increment the large integer by one and return the resulting array of digits.

// Example 1:
// Input: digits = [1,2,3]
// Output: [1,2,4]

public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {

            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
    public static void main(String[] args) {
        PlusOne outer = new PlusOne();
        Solution solution = outer.new Solution();

        // Test Case
        int[] digits = {9, 9, 9};
        int[] result = solution.plusOne(digits);

        // Print Result
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}