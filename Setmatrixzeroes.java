//  Problem Statement:
// Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
// The modification must be done in-place, i.e., without using extra space for another matrix.

//  Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

//  Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

//  Approach (In-place modification with constant space):
// 1. The key observation is that instead of using extra space to store the rows and columns that need to be set to zero,
//    we can use the first row and first column of the matrix itself to store this information.
// 2. We will mark the first row and column to record which rows and columns should be set to zero.
// 3. After processing all elements, we will iterate over the matrix and modify the elements as per the recorded information.

//  Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.
//  Space Complexity: O(1), as we are modifying the matrix in-place without extra space (other than for variables).

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroFirstCol = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (zeroFirstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
