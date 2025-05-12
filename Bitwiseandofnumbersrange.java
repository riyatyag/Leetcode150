    /**
     * Given two integers left and right that represent the range [left, right],
     * return the bitwise AND of all numbers in this range, inclusive.
     *
     * Example 1:
     * Input: left = 5, right = 7
     * Output: 4
     *
     * Example 2:
     * Input: left = 0, right = 0
     * Output: 0
     *
     * Example 3:
     * Input: left = 1, right = 2147483647
     * Output: 0
     *
     * Constraints:
     * 0 <= left <= right <= 2^31 - 1
     *
     * Approach:
     * The bitwise AND of a range of numbers will have a common prefix in their binary representations.
     * Once the binary representations differ at any bit position within the range, the bitwise AND for that position and all less significant positions will become 0.
     * We can find the common prefix by repeatedly right-shifting both left and right until they become equal.
     * The number of right shifts performed tells us how many trailing bits will be 0 in the result.
     * After left and right become equal, we left-shift the common value by the number of shifts to get the final result.
     *
     * Time Complexity: O(log(n)), where n is the difference between right and left in the worst case. The number of shifts is proportional to the number of bits that differ between left and right.
     * Space Complexity: O(1), as we only use a constant amount of extra space.
     *
     * Optimal Solution: The provided solution is already efficient and optimal for this problem.
     */
    class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}