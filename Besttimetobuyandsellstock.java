/*
Problem Statement:
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Constraints:
- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No profit can be made.

--------------------------------------------------------------------
Approach:

We need to find the maximum difference between two elements such that the larger element comes after the smaller one.

We'll use the following logic:
- Initialize `minPrice` to maximum possible value.
- Traverse through the array:
    - Keep track of the minimum price seen so far.
    - Calculate potential profit at each step by subtracting the current price with the minimum price.
    - Update the maximum profit if the current potential profit is greater.

This is an application of Kadane’s Algorithm-like optimization but for a stock buy/sell scenario.

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------------------------
Pseudocode:

1. Initialize minPrice to Integer.MAX_VALUE
2. Initialize maxProfit to 0
3. Loop through the prices:
    - minPrice = min(minPrice, currentPrice)
    - maxProfit = max(maxProfit, currentPrice - minPrice)
4. Return maxProfit

--------------------------------------------------------------------
*/

public class Besttimetobuyandsellstock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); 

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); 
    }
}
