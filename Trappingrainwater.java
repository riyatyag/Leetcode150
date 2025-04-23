// Problem Statement:
// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

// Approach:
// We can solve this problem using two-pointer technique. 
// 1. Initialize two pointers `left` and `right` at the start and end of the height array.
// 2. Use two variables `leftMax` and `rightMax` to store the maximum heights encountered so far from both directions.
// 3. Iterate using the two pointers and calculate the trapped water at each step. 
// 4. If the height at `left` pointer is less than the height at `right`, move the `left` pointer to the right.
// 5. Otherwise, move the `right` pointer to the left.

// Optimal Solution:
// The optimal solution has a time complexity of O(n), where n is the number of elements in the height array.
// The space complexity is O(1), as we are only using a few extra variables to store maximum values and water trapped.


// Pseudo Code:
// 1. Initialize `left` to 0, `right` to n-1, `leftMax` to 0, `rightMax` to 0, and `water` to 0.
// 2. While `left` is less than `right`:
//    a. If height[left] < height[right]:
//       i. If height[left] >= leftMax, update leftMax.
//       ii. Otherwise, calculate trapped water by `leftMax - height[left]` and add it to water.
//       iii. Move the left pointer to the right (left++).
//    b. Else:
//       i. If height[right] >= rightMax, update rightMax.
//       ii. Otherwise, calculate trapped water by `rightMax - height[right]` and add it to water.
//       iii. Move the right pointer to the left (right--).
// 3. Return the water.


class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
