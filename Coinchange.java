    /**
     * Problem Statement:
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     *
     * Approach:
     * This problem can be solved using dynamic programming. Let dp[i] be the minimum number of coins needed to make up the amount i.
     * Initialize dp[0] to 0, as 0 amount requires 0 coins.
     * Initialize the rest of the dp array with a value greater than the maximum possible answer (amount + 1) to represent infinity.
     * Iterate through each amount i from 1 to the target amount.
     * For each amount i, iterate through each coin denomination.
     * If the current coin denomination is less than or equal to the current amount i, it means we can potentially use this coin.
     * Update dp[i] as the minimum of its current value and dp[i - coin] + 1 (which represents using the current coin and the minimum number of coins needed for the remaining amount).
     * Finally, if dp[amount] is still greater than the initial "infinity" value, it means the amount cannot be made up by any combination of the coins, so return -1. Otherwise, return dp[amount].
     *
     * Time Complexity: O(amount * n), where amount is the target amount and n is the number of coin denominations.
     * Space Complexity: O(amount), as we use an array of size amount + 1 to store the minimum number of coins for each amount.
     *
     * Optimal Solution:
     */
    
    class Solution{
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}