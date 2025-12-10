
//! 120 Triangle

import java.util.*;

public class Triangle {

    // using extra space approach 1
    // class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    // int n = triangle.size();
    // int[] dp = new int[n];

    // // Step 1: copy last row
    // for (int i = 0; i < n; i++) {
    // dp[i] = triangle.get(n - 1).get(i);
    // }

    // // Step 2: bottom-up calculation
    // for (int i = n - 2; i >= 0; i--) {
    // for (int j = 0; j <= i; j++) {
    // dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
    // }
    // }

    // return dp[0];
    // }
    // }

    // in-place approach 2
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    int down = triangle.get(i + 1).get(j);
                    int diag = triangle.get(i + 1).get(j + 1);

                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(down, diag));
                }
            }
            return triangle.get(0).get(0);
        }

    //     using memoization approach 3
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int m = triangle.size();
    //     Integer[][] dp = new Integer[m][m];return

    //     print(triangle,0,0,triangle.size(),dp);

    // }

    //     public int print(List<List<Integer>> l, int i, int j, int m, Integer[][] dp) {
    //         if (i == m - 1) {
    //             return l.get(i).get(j);
    //         }
    //         if (dp[i][j] != null)
    //             return dp[i][j];
    //         return dp[i][j] = l.get(i).get(j) + Math.min(print(l, i + 1, j, m, dp), print(l, i + 1, j + 1, m, dp));
    //     }
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Solution solution = triangle.new Solution();

        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(2));
        tri.add(Arrays.asList(3, 4));
        tri.add(Arrays.asList(6, 5, 7));
        tri.add(Arrays.asList(4, 1, 8, 3));

        int result = solution.minimumTotal(tri);
        System.out.println(result); // Output: 11
    }

}
