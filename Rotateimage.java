//  Problem Statement:
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees clockwise.
// The rotation should be done in-place, modifying the input matrix directly without allocating another matrix.

//  Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

//  Example 2:
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

//  Approach (In-place rotation with transpose and reverse):
// 1. Transpose the matrix: Swap the elements matrix[i][j] and matrix[j][i].
// 2. Reverse each row of the matrix: After transposing, reverse the rows to get the final result.

//  Time Complexity: O(n^2), where n is the number of rows/columns (since we're iterating over the matrix twice).
//  Space Complexity: O(1), as we are modifying the matrix in-place.

// Code:

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
