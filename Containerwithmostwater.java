// ✅ Problem Statement:
// You are given an array `height` where each element represents a vertical line drawn from (i, 0) to (i, height[i]).
// Find two lines that together with the x-axis form a container that stores the maximum amount of water.

// ✅ Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation:
// - The best container is formed between lines at index 1 (height 8) and index 8 (height 7).
// - Width = 8 - 1 = 7
// - Height = min(8,7) = 7
// - Area = 7 * 7 = 49

// ✅ Example 2:
// Input: height = [1,1]
// Output: 1
// Explanation:
// - Width = 1
// - Height = min(1,1) = 1
// - Area = 1 * 1 = 1

// ✅ Approach (Two Pointers):
// 1. Initialize two pointers:
//    - `left` at the start (index 0)
//    - `right` at the end (index height.length - 1)
// 2. Calculate the area between the lines at `left` and `right`:
//    - width = right - left
//    - height = min(height[left], height[right])
//    - area = width * height
// 3. Keep track of the maximum area found so far.
// 4. Move the pointer pointing to the shorter line:
//    - If height[left] < height[right]: move `left++`
//    - Else: move `right--`
// 5. Continue until left < right.

// ✅ Why Move the Shorter Line?
// - Because the height of the container is limited by the shorter line.
// - To maximize area, we try to find a taller line by moving the shorter one inward.

// ✅ Time Complexity: O(n)
// - Only one pass from both ends.
// ✅ Space Complexity: O(1)
// - No extra space used except variables.

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h * w);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}
