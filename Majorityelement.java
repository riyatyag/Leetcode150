/*
 * Problem: 169. Majority Element (LeetCode)
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * Constraints:
 * - 1 <= nums.length <= 5 * 10^4
 * - -10^9 <= nums[i] <= 10^9
 * 
 * Follow-up:
 * Can you solve the problem in linear time and O(1) space?
 */

/*
 * Approach: Boyer-Moore Voting Algorithm
 * 
 * Idea:
 * - We want to find an element that occurs more than n/2 times.
 * - We use a counter and a candidate variable.
 * - Start with count = 0 and no candidate.
 * - For each element in the array:
 *     - If count == 0, make that element the candidate.
 *     - If the current element is the same as candidate, increment count.
 *     - Else, decrement count.
 * 
 * Why it works:
 * - Because the majority element appears more than n/2 times, the count
 *   will be positive at the end and the candidate will be the majority element.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/*
 * Pseudocode:
 * - Initialize count = 0
 * - Initialize candidate = 0
 * - For each number in the array:
 *     - If count == 0: candidate = num
 *     - If num == candidate: count++
 *     - Else: count--
 * - Return candidate
 */

 class Majorityelement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority Element in nums1: " + majorityElement(nums1)); // Output: 3
        System.out.println("Majority Element in nums2: " + majorityElement(nums2)); // Output: 2
    }
}

