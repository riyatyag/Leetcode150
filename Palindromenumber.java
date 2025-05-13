    /*
     * Given an integer x, return true if x is a palindrome, and false otherwise.
     *
     * Approach:
     * A number is a palindrome if it reads the same backward as forward.  Handle negative numbers and numbers ending in 0 as special cases.  For positive numbers, reverse the second half of the number and compare it with the first half.
     *
     * Time Complexity: O(log10(n)), where n is the input number x.
     *
     * Space Complexity: O(1), constant space.
     *
     * Optimal Solution:  Reversing only half of the number is the optimal approach.
     */

     class Solution {
       public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
