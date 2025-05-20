    /**
     * Problem Statement:
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
     * The only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     * Approach:
     * This problem can be solved using dynamic programming. Let dp[i] be the maximum amount of money that can be robbed up to the i-th house.
     * When considering the i-th house, there are two choices:
     * 1. Rob the i-th house: In this case, we cannot rob the (i-1)-th house, so the maximum amount will be dp[i-2] + nums[i].
     * 2. Do not rob the i-th house: In this case, the maximum amount will be the same as the maximum amount robbed up to the (i-1)-th house, which is dp[i-1].
     * Therefore, dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]).
     * The base cases are dp[0] = nums[0] (if there is only one house) and dp[1] = Math.max(nums[0], nums[1]) (if there are two houses).
     * We can optimize the space complexity by noticing that we only need the previous two values to calculate the current value.
     *
     * Time Complexity: O(n), where n is the number of houses. We iterate through the houses once.
     * Space Complexity: O(1), as we only store a constant number of variables.
     *
     * Optimal Solution:
     */

     class Solution {
     public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prev2 = 0;
        int prev1 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}