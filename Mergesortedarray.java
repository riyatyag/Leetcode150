// LeetCode 88. Merge Sorted Array
// Requirement:
// Given two sorted integer arrays nums1 and nums2 of size m and n respectively,
// merge nums2 into nums1 as one sorted array.
// The final array must be stored in-place inside nums1.

// Pseudocode:
// 1. Set pointer i to m - 1 (last valid element of nums1)
// 2. Set pointer j to n - 1 (last element of nums2)
// 3. Set pointer k to m + n - 1 (end of nums1)
// 4. While i >= 0 and j >= 0:
//      - if nums1[i] > nums2[j], set nums1[k] = nums1[i], decrement i and k
//      - else set nums1[k] = nums2[j], decrement j and k
// 5. While j >= 0:
//      - set nums1[k] = nums2[j], decrement j and k

public class Mergesortedarray {
    public static void main(String[] args) {
        int[] nums1 = new int[6];  
        int m = 3;  
        int[] nums2 = {1, 2, 3};  
        int n = 3;  

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
