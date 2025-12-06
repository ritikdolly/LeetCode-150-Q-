// ? https://leetcode.com/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-interview-150

// ! 22. Generate Parentheses
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]
import java.util.*;

public class GenerateParentheses {

    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n < 1) {
                return res;
            }
            backTrack(n, "", 0, 0);
            return res;
        }

        void backTrack(int n, String str, int open, int close) {
            if (str.length() == 2 * n) {
                res.add(str);
                return;
            }
            if (open < n) {
                backTrack(n, str + "(", open + 1, close);
            }
            if (close < open) {
                backTrack(n, str + ")", open, close + 1);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result); // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }

}
