   /**
     * Problem Statement:
     * Given a sorted rotated array nums of unique elements, return the minimum element of this array.
     * You must write an algorithm that runs in O(log n) time.
     *
     * Approach:
     * We can use a modified binary search approach to find the minimum element efficiently.
     * The key idea is to compare the middle element with the rightmost element.
     * If the middle element is greater than the rightmost element, it means the minimum element lies in the right half of the array.
     * Otherwise, the minimum element lies in the left half (including the middle element).
     *
     * Time Complexity: O(log n) - Binary search reduces the search space by half in each iteration.
     * Space Complexity: O(1) - Constant extra space is used.
     *
     * Optimal Solution:
     * The provided solution implements the described binary search approach.
     */
    class Solution{
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}