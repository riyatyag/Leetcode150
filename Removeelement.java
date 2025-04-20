// 1.Problem Description
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

// 2.Requirements
// Modify the array nums such that the first k elements of nums contain the elements that are not equal to val. The remaining elements of nums are not important.

// Return k, the count of elements not equal to val.

// 3.Pseudocode
// Set pointer k to 0, which will track the position to place non-val elements.

// Loop through the array nums:

// For each element in nums, if the element is not equal to val, assign it to nums[k] and increment k.

// After the loop ends, return k which is the number of elements in nums that are not equal to val.


public class Removeelement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};  
        int val = 3;  

        int k = removeElement(nums, val);

        System.out.println("Number of elements not equal to " + val + ": " + k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];  
                k++;  
            }
        }

        return k;  
    }
}
