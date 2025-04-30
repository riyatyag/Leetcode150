//  Problem Statement:
// You are given a sorted and unique integer array `nums`. 
// You need to return the smallest sorted list of ranges that cover all numbers in the array exactly.
// Each range [a, b] is returned as:
//  - "a->b" if a != b
//  - "a"     if a == b

//  Example 1:
// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]

//  Example 2:
// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]

//  Constraints:
// - 0 <= nums.length <= 20
// - -2^31 <= nums[i] <= 2^31 - 1
// - All elements in nums are unique and sorted in ascending order

//  Approach:
// - Initialize `start` with the first number.
// - Iterate through the array.
// - If the current number is not consecutive from the previous number:
//      - Add the range from `start` to `nums[i-1]`.
//      - Set `start = nums[i]`.
// - After the loop, make sure to add the last range.

//  Time Complexity: O(n), where n is the length of the array
//  Space Complexity: O(1) extra space (excluding output list)


class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) return result;

        int start = nums[0]; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];  
            }
        }

        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }

        return result;
    }
}
