    /**
     * Problem Statement:
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Approach:
     * We can use binary search to find the first and last occurrences of the target value.
     * To find the first occurrence, we perform a binary search and when we find the target, we continue searching in the left subarray to see if there's an earlier occurrence.
     * To find the last occurrence, we perform a similar binary search, but when we find the target, we continue searching in the right subarray for a later occurrence.
     *
     * Time Complexity: O(log n) - Two binary searches are performed on the array.
     * Space Complexity: O(1) - Constant extra space is used.
     *
     * Optimal Solution:
     * The provided solution implements the described approach using a helper function `findBound` to avoid code duplication.
     */
    class Solution {
          public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true);
        if (result[0] != -1) {
            result[1] = findBound(nums, target, false);
        }
        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}