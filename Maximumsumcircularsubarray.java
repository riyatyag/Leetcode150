/*
Problem Statement:
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
A circular array means the end of the array connects to the beginning of the array.
A subarray may only include each element of the fixed buffer nums at most once.

Approach:
The maximum subarray sum in a circular array can be found in two possible scenarios:
1. The maximum subarray is a non-circular subarray, meaning it lies entirely within the array without wrapping around. In this case, we can use Kadane's algorithm to find the maximum subarray sum.
2. The maximum subarray is a circular subarray, meaning it wraps around the end and the beginning of the array. In this case, the maximum sum can be obtained by taking the total sum of the array and subtracting the minimum subarray sum (which represents the part of the array that is *not* included in the maximum circular subarray).

We calculate both the maximum non-circular subarray sum using Kadane's algorithm and the minimum subarray sum (also using a modified Kadane's algorithm). The maximum circular subarray sum is then the total sum minus the minimum subarray sum. The final result is the maximum of these two values.

There is a special case where all numbers in the array are negative. In this case, the maximum subarray sum is simply the largest negative number (which will be captured by the initial `maxSum` in Kadane's algorithm). To handle this, we check if `maxSum` is negative, and if so, we return `maxSum`.

Time Complexity: O(n), where n is the length of the input array `nums`. We iterate through the array a constant number of times.

Space Complexity: O(1), as we are only using a constant amount of extra space for variables.

Optimal Solution:
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
