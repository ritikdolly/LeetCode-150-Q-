// ? https://leetcode.com/problems/powx-n/description/?envType=study-plan-v2&envId=top-interview-150

// ! 50. Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Input: x = 2.00000, n = 10
// Output: 1024.00000

public class PowerOfNumber {

    class Solution {
        public double myPow(double x, int n) {
            return Math.pow(x, n);
        }

        // using loop 
        // double myPow(double N, int P) {
        //     int pow = 1;
        //     for (int i = 1; i <= P; i++)
        //         pow *= N;
        //     return pow;
        // }
    }

    public static void main(String[] args) {
        Solution solution = new PowerOfNumber().new Solution();
        double x = 2.0;
        int n = 10;
        double result = solution.myPow(x, n);
        System.out.println(x + " raised to the power of " + n + " is: " + result);
    }

}