/*
Problem Statement:
122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock.
You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Constraints:
- 1 <= prices.length <= 3 * 10^4
- 0 <= prices[i] <= 10^4

Examples:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 and sell on day 3, profit = 4.
Then buy on day 4 and sell on day 5, profit = 3.
Total profit = 7.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 and sell on day 5, profit = 4.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No profit can be made.

--------------------------------------------------------------------
Approach:

We can sum all the increasing differences (valleys to peaks).
If prices[i] > prices[i - 1], then add the difference to profit.
We are allowed to buy and sell on the same day, so every upward movement contributes to the profit.

This is a greedy approach.

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------------------------
Pseudocode:

1. Initialize profit = 0
2. Loop i from 1 to prices.length - 1
   - If prices[i] > prices[i - 1], then:
     - profit += prices[i] - prices[i - 1]
3. Return profit

--------------------------------------------------------------------
*/

public class Besttimetobuyandsellstock2 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices2)); 

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices3)); 
    }
}
