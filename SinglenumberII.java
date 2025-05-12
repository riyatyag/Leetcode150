    /**
     * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * Example 1:
     * Input: nums = [2,2,3,2]
     * Output: 3
     *
     * Example 2:
     * Input: nums = [0,1,0,1,0,1,99]
     * Output: 99
     *
     * Constraints:
     * 1 <= nums.length <= 3 * 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     * Each element in nums appears exactly three times except for one element which appears once.
     *
     * Approach:
     * We can use bit manipulation to solve this problem. Consider the bits at each position for all numbers in the array.
     * For the numbers that appear three times, the count of '1's at each bit position will be a multiple of 3.
     * For the single number that appears once, the count of '1's at its bit positions will have a remainder of 1 when divided by 3.
     * We can iterate through each bit position (0 to 31 for a 32-bit integer) and count the number of '1's at that position across all numbers in the array.
     * If the count is not divisible by 3, it means the single number has a '1' at that position.
     * We can reconstruct the single number by setting the corresponding bit in our result.
     *
     * Time Complexity: O(n), where n is the number of elements in the array. We iterate through the array a constant number of times (once for each bit position, which is 32).
     * Space Complexity: O(1), as we only use a constant amount of extra space to store the counts and the result.
     *
     * Optimal Solution: The provided solution using bit manipulation is already optimal in terms of both time and space complexity as per the problem constraints.
     */
    class Solution {
     public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}