//  Problem Statement:
// Given an unsorted array of integers `nums`, return the length of the longest sequence of consecutive elements.
// You must write an algorithm that runs in O(n) time.

//  Example 1:
// Input: nums = [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].

//  Example 2:
// Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
// Output: 9
// Explanation: The sequence [0, 1, 2, 3, 4, 5, 6, 7, 8] is the longest.

//  Example 3:
// Input: nums = [1, 0, 1, 2]
// Output: 3

//  Constraints:
// - 0 <= nums.length <= 10^5
// - -10^9 <= nums[i] <= 10^9

//  Approach:
// 1. Use a HashSet to store all unique numbers from the array.
// 2. Iterate through each number in the set and only begin counting a sequence if the current number is the start of a sequence (i.e., num - 1 is not in the set).
// 3. Keep expanding the sequence and update the maximum length found so far.

//  Time Complexity: O(n), because each number is checked only once.
//  Space Complexity: O(n), due to the use of a HashSet for storing unique numbers.



class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
