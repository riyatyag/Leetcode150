/*
Problem Statement:
Given an integer array nums, return an array answer such that answer[i] 
is equal to the product of all the elements of nums except nums[i].

Constraints:
- Do not use the division operation.
- The solution must run in O(n) time.
- Try to achieve O(1) extra space complexity (excluding the output array).

Example:
Input: nums = [1, 2, 3, 4]
Output: [24, 12, 8, 6]

Input: nums = [-1, 1, 0, -3, 3]
Output: [0, 0, 9, 0, 0]

Approach:
- Initialize a result array of the same length.
- Traverse from left to right, storing the prefix product of all elements before the current index.
- Traverse from right to left using a variable to store the running suffix product,
  and multiply it with the current value in result[].
- This way, we build the final product array in two passes.

Pseudocode:
1. result[0] = 1
2. for i from 1 to n-1:
      result[i] = result[i-1] * nums[i-1]
3. rightProduct = 1
4. for i from n-1 down to 0:
      result[i] = result[i] * rightProduct
      rightProduct = rightProduct * nums[i]
5. return result

Optimal Solution:
- Time Complexity: O(n)
- Space Complexity: O(1) extra (excluding output array)
*/

class Productofarray {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}

