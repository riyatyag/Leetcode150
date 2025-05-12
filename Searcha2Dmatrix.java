    /**
     * Problem Statement:
     * You are given an m x n integer matrix matrix with the following two properties:
     * - Each row is sorted in non-decreasing order.
     * - The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     * You must write a solution in O(log(m * n)) time complexity.
     *
     * Approach:
     * Since the rows are sorted and the last element of each row is smaller than the first element of the next row,
     * we can treat the entire matrix as a single sorted array of m * n elements.
     * We can then apply binary search on this conceptual 1D array.
     * To find the row and column index corresponding to a middle index `mid` in the 1D array,
     * we can use: row = mid / n and col = mid % n, where n is the number of columns.
     *
     * Time Complexity: O(log(m * n)) - Binary search on the m * n elements.
     * Space Complexity: O(1) - Constant extra space is used.
     *
     * Optimal Solution:
     * The provided solution implements the described binary search approach on the conceptual 1D array.
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}