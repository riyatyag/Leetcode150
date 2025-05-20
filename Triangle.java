/**
     * Problem Statement:
     * Given a triangle array, return the minimum path sum from top to bottom.
     * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     *
     * Approach:
     * This problem can be solved using dynamic programming. We can work from the bottom of the triangle upwards.
     * Let dp[i] represent the minimum path sum from the i-th element of the current row to the bottom.
     * Initialize the dp array with the values of the last row of the triangle.
     * Iterate through the triangle rows from the second-to-last row up to the first row.
     * For each element in the current row at index j, the minimum path sum from this element to the bottom is the current element's value plus the minimum of the minimum path sums from its two adjacent elements in the row below (at indices j and j + 1).
     * Update dp[j] with this minimum path sum.
     * After iterating through all the rows, dp[0] will contain the minimum path sum from the top of the triangle to the bottom.
     *
     * Time Complexity: O(n^2), where n is the number of rows in the triangle. We iterate through all the elements of the triangle.
     * Space Complexity: O(n), where n is the number of rows in the triangle. We use a dp array of size n. This satisfies the follow-up requirement of O(n) extra space.
     *
     * Optimal Solution:
     */

    
 import java.util.List;
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];
    }
}