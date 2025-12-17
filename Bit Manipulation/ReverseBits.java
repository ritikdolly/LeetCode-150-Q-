// ? https://leetcode.com/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150

// ! 190. Reverse Bits
// Reverse bits of a given 32 bits signed integer.

// Example 1:
// Input: n = 43261596
// Output: 964176192

class Reverse{
   class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0, power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >>> 1;
            power -= 1;
        }
        return ret;
    }
}
    public static void main(String args[]){
        Solution sol = new Reverse().new Solution();
        int n = 43261596;
        int result = sol.reverseBits(n);
        System.out.println(result);
    }
}