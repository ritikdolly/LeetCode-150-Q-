//? https://leetcode.com/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150

//! 69. Sqrt(x)
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
// You must not use any built-in exponent function or operator.
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

// Input: x = 4
// Output: 2

public class SquareRoot {

    // Choose one implementation inside this class
    static class Solution {

        // ? Binary Search Method (accurate and accepted by LeetCode)
        public int mySqrt(int x) {
            if (x < 2)
                return x;

            int left = 1, right = x / 2, ans = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                long sq = (long) mid * mid;

                if (sq == x)
                    return mid;
                else if (sq < x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return ans;
        }

        // ? Option 2 (Simple Method using Math.sqrt)
        // public int mySqrt(int x) {
        // return (int) Math.sqrt(x);
        // }

    }

    // MAIN METHOD TO TEST
    public static void main(String[] args) {
        Solution sol = new Solution();

        int x = 17;
        int result = sol.mySqrt(x);

        System.out.println("Square root of " + x + " = " + result);
    }
}
