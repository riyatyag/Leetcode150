    /*
     * Given an integer n, return the number of trailing zeroes in n!.
     * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
     *
     * Approach:
     * The number of trailing zeros in n! is determined by the number of times 10 is a factor.
     * Since 10 = 2 * 5, and there are always more factors of 2 than 5, we only need to count the
     * number of factors of 5.  This can be done by summing the number of multiples of 5, 25, 125,
     * and so on, up to n.
     *
     * Time Complexity: O(log5(n)), as the loop iterates a logarithmic number of times with base 5.
     *
     * Space Complexity: O(1), constant space.
     *
     * Optimal Solution: The approach of counting factors of 5 is the optimal solution.
     */
    class Solution {
      public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}