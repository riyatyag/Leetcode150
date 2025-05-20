/**
     * Problem Statement:
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     *
     * Approach:
     * This problem can be solved using dynamic programming. Let dp[i] be the length of the longest increasing subsequence ending at index i.
     * Initialize dp[i] to 1 for all i, as each element itself forms an increasing subsequence of length 1.
     * Iterate through the array nums from the second element (index 1) to the end.
     * For each element nums[i], iterate through all the previous elements nums[j] (where j < i).
     * If nums[i] is strictly greater than nums[j], it means we can extend the increasing subsequence ending at j by including nums[i].
     * In this case, update dp[i] to be the maximum of its current value and dp[j] + 1.
     * After iterating through all the elements, the length of the longest increasing subsequence in the entire array will be the maximum value in the dp array.
     *
     * Time Complexity: O(n^2), where n is the length of the input array nums. The outer loop runs n times, and the inner loop also runs up to n times in the worst case.
     * Space Complexity: O(n), as we use an array dp of size n to store the lengths of the longest increasing subsequences ending at each index.
     *
     * Optimal Solution (Follow-up): O(n log n) using patience sorting and binary search.
     */

     import java.util.Arrays;

     class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}