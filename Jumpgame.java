// Problem Statement:
// You are given an integer array nums. You are initially positioned at the array's first index, 
// and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.
//
// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
// Example 2:
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
// which makes it impossible to reach the last index.
//
// Constraints:
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 10^5

// Optimal Approach:
// The idea is to iterate through the array and keep track of the farthest index we can reach so far. 
// If at any point the current index is greater than the farthest index we can reach, then it's 
// impossible to move forward and we return false. If we can traverse the entire array and 
// reach or surpass the last index, we return true.


public class Jumpgame {
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        
        System.out.println(canJump(nums1));  
        System.out.println(canJump(nums2));  
    }
}
