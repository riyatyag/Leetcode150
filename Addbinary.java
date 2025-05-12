    /**
     * Given two binary strings a and b, return their sum as a binary string.
     *
     * Example 1:
     * Input: a = "11", b = "1"
     * Output: "100"
     *
     * Example 2:
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * Constraints:
     * 1 <= a.length, b.length <= 10^4
     * a and b consist only of '0' or '1' characters.
     * Each string does not contain leading zeros except for the zero itself.
     *
     * Approach:
     * Iterate through the binary strings from right to left, keeping track of the carry.
     * For each digit position, add the corresponding digits of the two strings and the carry.
     * The result digit at the current position is the remainder of the sum divided by 2.
     * The new carry is the quotient of the sum divided by 2.
     * Append the result digit to a StringBuilder.
     * After iterating through both strings, if there is still a carry, append it to the StringBuilder.
     * Finally, reverse the StringBuilder and return the result as a string.
     *
     * Time Complexity: O(max(m, n)), where m and n are the lengths of strings a and b respectively.
     * Space Complexity: O(max(m, n)), for the StringBuilder to store the result.
     *
     * Optimal Solution: The provided solution is already efficient with a time complexity proportional to the length of the longer string.
     */

     class Solution {
      public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}