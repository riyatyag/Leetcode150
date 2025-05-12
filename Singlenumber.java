    /**
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     *
     * Example 1:
     * Input: nums = [2,2,1]
     * Output: 1
     *
     * Example 2:
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     * Example 3:
     * Input: nums = [1]
     * Output: 1
     *
     * Constraints:
     * 1 <= nums.length <= 3 * 10^4
     * -3 * 10^4 <= nums[i] <= 3 * 10^4
     * Each element in the array appears twice except for one element which appears only once.
     *
     * Approach:
     * The problem requires a solution with linear time complexity and constant extra space.
     * The bitwise XOR operation has the property that x ^ x = 0 and x ^ 0 = x.
     * If we XOR all the elements in the array, the elements that appear twice will cancel each other out (their XOR will be 0),
     * and the only element that appears once will remain.
     *
     * Time Complexity: O(n), where n is the number of elements in the array, as we iterate through the array once.
     * Space Complexity: O(1), as we only use a constant amount of extra space to store the result.
     *
     * Optimal Solution: The provided solution using the XOR operation is already optimal in terms of both time and space complexity as per the problem constraints.
     */

     class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}