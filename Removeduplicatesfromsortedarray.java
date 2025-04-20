// 1.Problem Breakdown
// Given a sorted integer array nums, you need to remove the duplicates in-place such that each unique element appears only once. You should return the number of unique elements and modify the array in-place so that the first k elements contain only unique elements.

// 2.Approach
// Two-pointer Technique:

// One pointer (i) will track the last unique element.

// The other pointer (j) will traverse the array to check for unique elements.

// If nums[j] is not equal to nums[i], we increment i and update nums[i] to nums[j].

//3 Result

// The first k elements of the nums array will contain the unique elements.

// Return k, the number of unique elements.

public class Removeduplicatesfromsortedarray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Removeduplicatesfromsortedarray sol = new Removeduplicatesfromsortedarray();
        int[] nums1 = {1, 1, 2};
        System.out.println(sol.removeDuplicates(nums1));
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(sol.removeDuplicates(nums2));
    }
}
