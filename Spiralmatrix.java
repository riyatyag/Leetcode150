//  Problem Statement:
// Given an m x n matrix, return all elements of the matrix in spiral order.
// The order starts from the top-left corner, traverses the matrix in a spiral pattern (right, down, left, up), and continues until all elements are visited.

//  Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

//  Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

//  Approach (Simulate the spiral traversal):
// 1. We will use four boundaries (top, bottom, left, right) to represent the current submatrix.
// 2. Traverse from left to right along the top row, then move down along the right column, then move right to left along the bottom row, and finally move up along the left column.
// 3. After each traversal, shrink the boundaries accordingly and repeat until the entire matrix is traversed.

//  Time Complexity: O(m * n), where m is the number of rows and n is the number of columns (since we're visiting each element once).
//  Space Complexity: O(1), as we only use a few pointers to represent the current boundaries.

// Code:

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
