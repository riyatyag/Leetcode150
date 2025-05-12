    /**
     * Problem Statement:
     * A peak element is an element that is strictly greater than its neighbors.
     * Given a 0-indexed integer array nums, find a peak element, and return its index.
     * If the array contains multiple peaks, return the index to any of the peaks.
     * You may imagine that nums[-1] = nums[n] = -∞.
     * You must write an algorithm that runs in O(log n) time.
     *
     * Approach:
     * We can use binary search to find a peak element.
     * In each step, we compare the middle element with its right neighbor.
     * If the middle element is greater than its right neighbor, it means a peak exists in the left half (including the middle element).
     * Otherwise, a peak exists in the right half (excluding the middle element).
     * We continue this process until the left and right pointers converge to a peak element.
     *
     * Time Complexity: O(log n) - Binary search reduces the search space by half in each iteration.
     * Space Complexity: O(1) - Constant extra space is used.
     *
     * Optimal Solution:
     * The provided solution implements the described binary search approach.
     **/
    class Solution {
         public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}