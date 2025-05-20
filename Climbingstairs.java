    /**
     * Problem Statement:
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Approach:
     * This problem can be solved using dynamic programming. Let dp[i] be the number of distinct ways to climb to the i-th step.
     * To reach the i-th step, we can either come from the (i-1)-th step by taking a 1-step, or from the (i-2)-th step by taking a 2-step.
     * Therefore, the number of ways to reach the i-th step is the sum of the number of ways to reach the (i-1)-th step and the number of ways to reach the (i-2)-th step.
     * The base cases are dp[1] = 1 (one way to reach the first step) and dp[2] = 2 (two ways to reach the second step: 1+1 or 2).
     * We can optimize the space complexity by observing that we only need the previous two values to calculate the current value.
     *
     * Time Complexity: O(n), where n is the number of steps. We iterate through the steps once.
     * Space Complexity: O(1), as we only store a constant number of variables.
     *
     * Optimal Solution:
     */
    class Solution {
     public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
}