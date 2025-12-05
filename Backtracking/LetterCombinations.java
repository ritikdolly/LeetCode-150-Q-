//?  https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150

// ! 17. Letter Combinations of a Phone Number
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {

            String mappings[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", };

            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return result;
            }

            // Call the recursive helper function
            backtrack(result, new StringBuilder(), digits, 0, mappings);
            return result;
        }

        private static void backtrack(List<String> result, StringBuilder current, String digits, int index,
                String[] mappings) {
            // Base case: if the current combination's length equals the input digits'
            // length
            if (index == digits.length()) {
                result.add(current.toString());
                return;
            }

            // Get the letters corresponding to the current digit
            String letters = mappings[digits.charAt(index) - '0'];

            // Iterate through the letters and make recursive calls
            for (char letter : letters.toCharArray()) {
                current.append(letter); // Add the letter to the current combination
                backtrack(result, current, digits, index + 1, mappings); // Recurse to the next digit
                current.deleteCharAt(current.length() - 1); // Backtrack by removing the last letter
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new LetterCombinations().new Solution();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
}
