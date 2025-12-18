// ? https://leetcode.com/problems/number-of-1-bits/description/?envType=study-plan-v2&envId=top-interview-150

// ! 191. Number of 1 Bits
// Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

// Example 1:
// Input: n = 11
// Output: 3

public class NumberofOneBits {
    class Solution {
        public int hammingWeight(int n) {
            int count = 0;

            while (n != 0) {
                count += (n & 1);
                n >>>= 1; // logical shift
            }

            return count;
        }
}
    public static void main(String args[]){
        Solution sol = new NumberofOneBits().new Solution();
        int n = 11; // Example input
        int result = sol.hammingWeight(n);
        System.out.println("Number of 1 bits in " + n + " is: " + result);
    }
}
