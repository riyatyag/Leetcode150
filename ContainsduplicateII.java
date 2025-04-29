//  Problem Statement:
// Given an integer array nums and an integer k, return true if there are two distinct indices i and j 
// in the array such that nums[i] == nums[j] and abs(i - j) <= k.

//  Example 1:
// Input: nums = [1,2,3,1], k = 3
// Output: true

//  Example 2:
// Input: nums = [1,0,1,1], k = 1
// Output: true

//  Example 3:
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

//  Approach (HashMap to store last seen index of each number):
// - Use a HashMap to keep track of the last index where each number was seen.
// - As you iterate through the array, check if the current number already exists in the map.
//   If it does, and the difference between the current index and the stored index is ≤ k, return true.
// - Otherwise, update the map with the current index.

// Time Complexity: O(n), where n is the length of the array (each element is processed once).
//  Space Complexity: O(n), for storing elements in the HashMap.


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
