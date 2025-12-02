// ? https://leetcode.com/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150

// ! 39 Combination Sum
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]

import java.util.*;

public class CombinationSum {
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backTracking(candidates, target, new ArrayList<>(), 0, 0);
            return res;
        }

        void backTracking(int[] candidates, int target, List<Integer> curr, int sum, int start) {
            if (sum == target) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < candidates.length; i++) {

                if (sum + candidates[i] > target) {
                    continue;
                }
                curr.add(candidates[i]);
                backTracking(candidates, target, curr, sum + candidates[i], i);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}
