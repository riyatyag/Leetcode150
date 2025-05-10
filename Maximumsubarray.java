/*
Problem Statement:
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Approach:
The problem asks for the maximum sum of a contiguous subarray within a given array of integers. This can be efficiently solved using Kadane's algorithm. The core idea of Kadane's algorithm is to iterate through the array, keeping track of the current maximum subarray sum ending at the current position.

We initialize two variables: `maxSum` to store the overall maximum subarray sum found so far (initialized with the first element of the array) and `currentSum` to store the maximum subarray sum ending at the current element (also initialized with the first element).

We then iterate through the array starting from the second element. For each element `nums[i]`, we have two choices for the maximum subarray ending at this position:
1. The subarray starts at the current element `nums[i]`.
2. The subarray extends the previous maximum subarray ending at `nums[i-1]` by including `nums[i]`.

We take the maximum of these two choices and update `currentSum`:
`currentSum = Math.max(nums[i], currentSum + nums[i])`

After updating `currentSum`, we compare it with the overall `maxSum` found so far and update `maxSum` if `currentSum` is greater:
`maxSum = Math.max(maxSum, currentSum)`

After iterating through the entire array, `maxSum` will hold the largest sum of any contiguous subarray.

Time Complexity: O(n), where n is the length of the input array `nums`. We iterate through the array once.

Space Complexity: O(1), as we are only using a constant amount of extra space for the variables `maxSum` and `currentSum`.

Optimal Solution:
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
