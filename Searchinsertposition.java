/*
Problem Statement:
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Approach:
The problem requires us to find the index of a target value in a sorted array. If the target is not found, we need to return the index where it would be inserted to maintain the sorted order. The constraint of O(log n) runtime complexity strongly suggests the use of binary search.

We initialize two pointers, `left` and `right`, to the start and end of the array, respectively. We then perform binary search:
1. Calculate the middle index `mid`.
2. If the element at `nums[mid]` is equal to the `target`, we have found the target and return `mid`.
3. If `nums[mid]` is less than the `target`, it means the target must be in the right half of the array (or inserted after the right half), so we update `left = mid + 1`.
4. If `nums[mid]` is greater than the `target`, it means the target must be in the left half of the array (or inserted before the left half), so we update `right = mid - 1`.

The loop continues until `left` becomes greater than `right`. At this point, `left` will be the index where the `target` should be inserted to maintain the sorted order.

Time Complexity: O(log n), where n is the length of the input array `nums`. This is because in each iteration of the while loop, the search space is halved.

Space Complexity: O(1), as we are only using a constant amount of extra space for the pointers `left`, `right`, and `mid`.

Optimal Solution:
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}



