    /*
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     *
     * Approach:
     * The naive approach of multiplying x by itself n times results in O(n) time complexity.  A more efficient approach utilizes the property of exponentiation:
     * x^n = (x^(n/2))^2 if n is even, and x^n = x * (x^(n/2))^2 if n is odd.  This can be implemented recursively.  Handle negative exponents by taking the reciprocal of x.
     * Handle the edge case where n is Integer.MIN_VALUE carefully to avoid overflow.
     *
     * Time Complexity: O(log n), due to the halving of n in each recursive call.
     *
     * Space Complexity: O(log n), due to the recursive call stack.  Iterative solution exists with O(1) space.
     *
     * Optimal Solution: The recursive (or iterative) approach using binary exponentiation is the optimal solution.
     */
    class Solution {
       public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}
