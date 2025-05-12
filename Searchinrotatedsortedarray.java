    /**
     * Problem Statement:
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Approach:
     * We can use a modified binary search. The idea is to check if the left half of the array is sorted or the right half is sorted.
     * If the left half is sorted, we check if the target lies within the left half. If it does, we search in the left half; otherwise, we search in the right half.
     * Similarly, if the right half is sorted, we check if the target lies within the right half. If it does, we search in the right half; otherwise, we search in the left half.
     *
     * Time Complexity: O(log n) - Binary search reduces the search space by half in each iteration.
     * Space Complexity: O(1) - Constant extra space is used.
     *
     * Optimal Solution:
     * The provided solution implements the described modified binary search approach.
     */
    class Solution {
             public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}