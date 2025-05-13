    /*
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     *
     * Approach:
     * Iterate through the digits array from right to left.  If a digit is less than 9, increment it and return the array.  If a digit is 9, set it to 0 and continue the iteration.  If all digits are 9, create a new array with a size of digits.length + 1, set the first element to 1, and return it.
     *
     * Time Complexity: O(n), where n is the length of the digits array.
     *
     * Space Complexity: O(1) in the average case, O(n) in the worst case (when all digits are 9).
     *
     * Optimal Solution: The approach of iterating from right to left and handling the carry is the optimal solution.
     */

     class Solution {
       public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}