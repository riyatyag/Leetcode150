// Problem Statement:
// Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// Return the answer in any order.

//  Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

//  Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

//  Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

//  Constraints:
// - 2 <= nums.length <= 10^4
// - -10^9 <= nums[i], target <= 10^9
// - Only one valid answer exists.

//  Follow-Up:
// Can you come up with an algorithm that is less than O(n²) time complexity?

//  Approach (Using HashMap - Optimal):
// - Use a HashMap to store the value and its index as we iterate through the array.
// - For each number, calculate the complement (`target - nums[i]`) and check if it’s already in the map.
// - If yes, we’ve found the answer. If not, store the number and index in the map.

//  Time Complexity: O(n), where n is the number of elements in the array.
//  Space Complexity: O(n), to store up to n elements in the HashMap.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
