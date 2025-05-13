    /*
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     * The returned integer should be non-negative as well.
     * You must not use any built-in exponent function or operator.
     *
     * Approach:
     * Use binary search. The square root of x lies between 0 and x.
     * Initialize left = 0 and right = x. While left <= right, calculate mid.
     * If mid * mid <= x, update ans = mid and left = mid + 1. Otherwise, right = mid - 1.
     * Handle the edge case where x is 0 or 1. To avoid overflow, compare mid <= x / mid instead of mid * mid <= x.
     *
     * Time Complexity: O(log x), due to the binary search.
     *
     * Space Complexity: O(1), constant space.
     *
     * Optimal Solution: Binary search is the optimal solution.
     */
    class Solution {
       public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
