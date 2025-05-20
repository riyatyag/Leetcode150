// Problem Statement:
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.

// Approach:
// Dynamic programming. Modify the input grid in place to store the minimum path sum to reach each cell.

// Time Complexity:
// O(m * n), where m is the number of rows and n is the number of columns in the grid.

// Space Complexity:
// O(1), as we modify the input grid in place.

// Optimal Solution:

 class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
         int n = grid[0].length;
        for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
               else if (j == 0) grid[i][j] += grid[i - 1][j];
              else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
          }
              }
        return grid[m - 1][n - 1];
    }
 }
