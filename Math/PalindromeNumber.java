// ? https://leetcode.com/problems/palindrome-number/description/?envType=study-plan-v2&envId=top-interview-150

// ! title=Palindrome Number
// Given an integer x, return true if x is a palindrome, and false otherwise.

// Example 1:
// Input: x = 121
// Output: true

// Example 2:
// Input: x = -121
// Output: false

public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            int number = x;
            int reverse = 0;
            if (x < 0) {
                return false;
            }
            while (x != 0) {
                reverse = reverse * 10 + (x % 10);
                x /= 10;
            }
            return (reverse == number);
        }
    }

    public static void main(String[] args) {
        PalindromeNumber outer = new PalindromeNumber();
        Solution solution = outer.new Solution();

        // Test Case
        int x = 121;
        boolean result = solution.isPalindrome(x);

        // Print Result
        System.out.println("Is Palindrome: " + result);
    }
}
