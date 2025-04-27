//  Problem Statement:
// Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray 
// whose sum is greater than or equal to `target`. If no such subarray exists, return 0 instead.

//  Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length with sum >= target.

//  Example 2:
// Input: target = 4, nums = [1,4,4]
// Output: 1
// Explanation: The subarray [4] has the sum = target.

//  Example 3:
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
// Explanation: No subarray has sum >= target.

//  Approach (Sliding Window Technique):
// 1. Use a sliding window approach: 
//    - Expand the window by moving the `end` pointer and include elements in the window.
//    - Once the sum of the window is >= target, move the `start` pointer to shrink the window and check for smaller subarrays.
 
// 2. Update the `minLen` whenever a valid subarray is found (sum >= target).

//  Why Sliding Window?
// - It reduces the time complexity by allowing us to traverse the array only once, making the solution O(n) time.

//  Time Complexity: O(n)
//  Space Complexity: O(1)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0; 
        int start = 0; 
        
        for (int end = 0; end < n; end++) {
            currentSum += nums[end];

            while (currentSum >= target) {
                minLen = Math.min(minLen, end - start + 1); 
                currentSum -= nums[start]; 
                start++; 
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
