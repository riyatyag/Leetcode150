//  📝 Problem Statement:
//  Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

//  Example 1:
//  Input: nums = [1,2,3,4,5,6,7], k = 3
//  Output: [5,6,7,1,2,3,4]

//  Example 2:
//  Input: nums = [-1,-100,3,99], k = 2
//  Output: [3,99,-1,-100]

//  Constraints:
//  - 1 <= nums.length <= 10^5
//  - -2^31 <= nums[i] <= 2^31 - 1
//  - 0 <= k <= 10^5

//  🔁 Follow-up:
//  Try to do it in-place with O(1) extra space.
// 

/*
 ✅ Approach:
 1. Rotating an array `k` times to the right is same as:
    → Moving the last `k` elements to the front, and shifting the first `n-k` elements to the back.
 2. To do this **in-place**, we use the **reversal algorithm**:
    → Step 1: Reverse the whole array.
    → Step 2: Reverse the first `k` elements.
    → Step 3: Reverse the rest `n-k` elements.

 ⌛ Time Complexity: O(n)
 📦 Space Complexity: O(1)

 🔧 Pseudocode:
 function rotate(nums, k):
     k = k % n
     reverse(nums, 0, n-1)
     reverse(nums, 0, k-1)
     reverse(nums, k, n-1)
*/

public class Rotatearray {
    public static void main(String[] args) {
        // Test example
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        // In case k is greater than array length
        k = k % n;

        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the rest
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
