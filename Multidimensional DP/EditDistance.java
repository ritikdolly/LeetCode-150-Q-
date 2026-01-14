// ? https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=top-interview-150

// ! 72. Edit Distance
// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
 

// Example 1:

// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')


public class EditDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[][] costDP = new int[m + 1][n + 1];

            // for first row
            for (int i = 1; i <= m; i++) {
                costDP[i][0] = i;
            }

            // for first column
            for (int i = 1; i <= n; i++) {
                costDP[0][i] = i;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        costDP[i][j] = costDP[i - 1][j - 1];
                    } else {
                        int topLeft = costDP[i - 1][j - 1];
                        int top = costDP[i - 1][j];
                        int left = costDP[i][j - 1];
                        costDP[i][j] = Math.min(topLeft, Math.min(top, left)) + 1;
                    }
                }
            }
            return costDP[m][n];
        }
}
    public static void main(String[] args) {
        EditDistance outer = new EditDistance();
        Solution solution = outer.new Solution();

        // Test Case
        String word1 = "intention";
        String word2 = "execution";
        int result = solution.minDistance(word1, word2);

        // Print Result
        System.out.println("Minimum Edit Distance: " + result);
    }
}
