// File Name: Jumpgame2.java

// Problem Statement:
// You are given a 0-indexed array of integers `nums` of length `n`.
// You are initially positioned at `nums[0]`.
// Each element `nums[i]` represents the maximum length of a forward jump from index i. 
// In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//  0 <= j <= nums[i] and
//  i + j < n
// Return the minimum number of jumps to reach nums[n - 1].
// The test cases are generated such that you can reach nums[n - 1].

// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Example 2:
// Input: nums = [2,3,0,1,4]
// Output: 2

// Constraints:
// 1 <= nums.length <= 10^4
// 0 <= nums[i] <= 1000
// It's guaranteed that you can reach nums[n - 1].


public class Jumpgame2 {

    public int jump(int[] nums) {
        int jumps = 0;  
        int end = 0;   
        int farthest = 0;  

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update farthest point we can reach

            if (i == end) {
                jumps++;  
                end = farthest;  

                if (end >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;  
    }

    public static void main(String[] args) {
        Jumpgame2 solution = new Jumpgame2();

        int[] testCase1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for test case 1: " + solution.jump(testCase1));

        int[] testCase2 = {2, 3, 0, 1, 4};
        System.out.println("Minimum jumps for test case 2: " + solution.jump(testCase2));

        int[] testCase3 = {1, 1, 1, 1, 1};
        System.out.println("Minimum jumps for test case 3: " + solution.jump(testCase3));

        int[] testCase4 = {5, 4, 1, 1, 1, 1, 1};
        System.out.println("Minimum jumps for test case 4: " + solution.jump(testCase4));
    }
}

/*
Optimal Approach:
1. The approach uses a greedy strategy.
2. We iterate through the array and keep track of the farthest index we can reach at each step.
3. When we reach the end of the current jump range, we make a jump to the farthest index we can reach and update the jump count.
4. This continues until we can reach the last index of the array.
5. The number of jumps is minimized by choosing the farthest possible jump at each step.

Pseudocode:
1. Initialize variables: `jumps = 0`, `end = 0`, `farthest = 0`.
2. Loop through the array (except for the last element):
   a. For each index `i`, calculate the farthest point that can be reached: `farthest = max(farthest, i + nums[i])`.
   b. If the current index `i` is the end of the current jump range (`i == end`):
      i. Increment the jump count: `jumps++`.
      ii. Update the `end` to `farthest`.
      iii. If `end` reaches or exceeds the last index (`end >= nums.length - 1`), break the loop.
3. Return `jumps` as the result.
*/

