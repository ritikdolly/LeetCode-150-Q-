// ? https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150

// !74. Search a 2D Matrix
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

public class Search2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] == target) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }
}
