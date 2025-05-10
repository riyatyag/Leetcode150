/*
Problem Statement:
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Approach:
The problem requires finding the median of two sorted arrays with a logarithmic time complexity. This suggests using a binary search approach. The core idea is to partition both arrays into two halves such that the elements in the left halves are smaller than or equal to the elements in the right halves. The median can then be determined based on the maximum of the left halves and the minimum of the right halves.

Time Complexity: O(log(min(m, n))), where m and n are the lengths of the two arrays. The binary search is performed on the smaller array.

Space Complexity: O(1), as we are not using any extra space proportional to the input size.

Optimal Solution:
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;
        int half = (m + n + 1) / 2;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = half - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted.");
    }
}





