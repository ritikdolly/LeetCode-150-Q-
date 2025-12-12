//?https://leetcode.com/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-interview-150 

//! 5. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.
// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2)
                return s;

            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len = Math.max(expandFromCenter(s, i, i), expandFromCenter(s, i, i + 1));

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandFromCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }

    }
    public static void main(String[] args) {
        Solution sol = new LongestPalindromicSubstring().new Solution();
        String s = "babad";
        String result = sol.longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result); // Output: "bab" or "aba"
    }
}
