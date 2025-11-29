// ?https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150

// ! 77 Combinations
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.

// Example 1:
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backTrack(1, n, k, new ArrayList<>());
            return res;
        }

        void backTrack(int start, int n, int k, List<Integer> curr) {
            if (curr.size() == k) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i <= n; i++) {
                curr.add(i);
                backTrack(i + 1, n, k, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Combinations().new Solution();
        int n = 4, k = 2;
        List<List<Integer>> result = sol.combine(n, k);
        System.out.println(result);
    }
}
