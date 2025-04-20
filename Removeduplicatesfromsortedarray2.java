// Problem Statement:
// Given a sorted integer array 'nums', remove duplicates in-place such that each unique element appears at most twice.
// The relative order should be preserved. Modify the array in-place with O(1) extra memory and return the new length.

// Constraints:
// 1 <= nums.length <= 3 * 10^4
// -10^4 <= nums[i] <= 10^4
// Array is sorted in non-decreasing order.

// Example:
// Input: nums = [1,1,1,2,2,3]
// Output: 5, with nums modified as [1,1,2,2,3,_]

// Approach:
// - Since we can allow at most 2 occurrences of each number, we can start from index 2.
// - Traverse the array from index 2.
// - For each element at index j, compare it with the element at index i - 2 (last second inserted).
// - If nums[j] != nums[i - 2], it means we can safely keep it.
// - Place nums[j] at nums[i] and increment i.
// - Return i as the new length.

// Pseudocode:
// if length <= 2 → return length
// initialize i = 2
// loop j from 2 to end:
//     if nums[j] != nums[i - 2]:
//         nums[i] = nums[j]
//         i++
// return i

public class Removeduplicatesfromsortedarray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Removeduplicatesfromsortedarray2 sol = new Removeduplicatesfromsortedarray2();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.print("Output 1: k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.print("Output 2: k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

