// Problem Statement:
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Approach:
// Dynamic Programming. Create a 2D dp array where dp[i][j] represents the side length of the largest square ending at (i-1, j-1).

// Time Complexity:
// O(m * n), where m is the number of rows and n is the number of columns.

// Space Complexity:
// O(m * n) for the dp array.

// Optimal Solution:

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
