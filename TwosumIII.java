// ✅ Problem Statement:
// Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Return their indices (1-based), i.e., [index1, index2].

// ✅ Example 1:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: 2 + 7 = 9. So, indices are 1 and 2.

// ✅ Example 2:
// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: 2 + 4 = 6. So, indices are 1 and 3.

// ✅ Example 3:
// Input: numbers = [-1,0], target = -1
// Output: [1,2]
// Explanation: -1 + 0 = -1. So, indices are 1 and 2.

// ✅ Approach (Two Pointers):
// 1. Since the array is sorted, initialize two pointers:
//    - `left` at the beginning (index 0)
//    - `right` at the end (index numbers.length - 1)
// 2. Calculate the sum of numbers[left] + numbers[right].
// 3. If the sum is equal to target:
//    - Return [left+1, right+1] (because array is 1-indexed).
// 4. If the sum is less than the target:
//    - Move `left` pointer one step to the right (increase sum).
// 5. If the sum is greater than the target:
//    - Move `right` pointer one step to the left (decrease sum).
// 6. Repeat until the two pointers meet.

// ✅ Pseudo Code:
// left = 0, right = numbers.length - 1
// while left < right:
//     sum = numbers[left] + numbers[right]
//     if sum == target: return [left + 1, right + 1]
//     else if sum < target: left++
//     else: right--

// ✅ Time Complexity: O(n)
// - Single pass through the array with two pointers.
// ✅ Space Complexity: O(1)
// - No extra space used, only two variables.

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {}; 
    }
}
