// ? https://leetcode.com/problems/factorial-trailing-zeroes/description/?envType=study-plan-v2&envId=top-interview-150

//! Factorial Trailing Zeroes
// Given an integer n, return the number of trailing zeroes in n!.
// Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

// Input: n = 3
// Output: 0
// Explanation: 3! = 6, no trailing zero.

// Input: n = 5
// Output: 1
// Explanation: 5! = 120, one trailing zero.

public class FactorialTrailingZeroes {
    //
    class Solution {

        public int trailingZeroes(int n) {
            int count = 0;
            while (n > 0) {
                n /= 5;
                count += n;
            }
            return count;

        }
    }
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        int n = 100;
        int result = solution.trailingZeroes(n);
        System.out.println("The number of trailing zeroes in " + n + "! is: " + result);
        
    }
}
