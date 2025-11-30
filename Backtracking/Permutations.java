// ?https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150

// ! 46 Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // ? using boolean array to track used elements
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backTrack(nums, new boolean[nums.length], new ArrayList<>());
            return res;
        }

        void backTrack(int[] nums, boolean[] used, List<Integer> curr) {
            if (curr.size() == nums.length) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                backTrack(nums, used, curr);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }

    // ? using swapping approach
    // class Solution {
    //     public List<List<Integer>> permute(int[] nums) {
    //         List<List<Integer>> res = new ArrayList<>();
    //         permuteHelper(nums, 0, res);
    //         return res;
    //     }

    //     private void permuteHelper(int[] nums, int i, List<List<Integer>> res) {
    //         if (i == nums.length) {
    //             List<Integer> permutation = new ArrayList<>();
    //             for (int num : nums)
    //                 permutation.add(num);
    //             res.add(permutation);
    //             return;
    //         }

    //         for (int j = i; j < nums.length; j++) {
    //             swap(nums, i, j);
    //             permuteHelper(nums, i + 1, res);
    //             swap(nums, i, j);
    //         }
    //     }

    //     private void swap(int[] nums, int i, int j) {
    //         int tmp = nums[i];
    //         nums[i] = nums[j];
    //         nums[j] = tmp;
    //     }
    // }

    public static void main(String[] args) {
        Solution sol = new Permutations().new Solution();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = sol.permute(nums);
        System.out.println(result);
    }

}
