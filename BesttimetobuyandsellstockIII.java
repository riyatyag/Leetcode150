// Problem Statement:
// You are given an array prices where prices[i] is the price of a given stock on the ith day. Find the maximum profit you can achieve. You may complete at most two transactions.  Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

// Approach:
// Maintain four variables: buy1, sell1, buy2, and sell2. buy1 and sell1 represent the first transaction, and buy2 and sell2 represent the second transaction.

// Time Complexity:
// O(n), where n is the number of prices.

// Space Complexity:
// O(1).

// Optimal Solution:

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
