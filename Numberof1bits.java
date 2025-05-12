    /**
     * Given a positive integer n, write a function that returns the number of set bits
     * in its binary representation (also known as the Hamming weight).
     *
     * Example 1:
     * Input: n = 11
     * Output: 3
     * Explanation: The input binary string 1011 has a total of three set bits.
     *
     * Example 2:
     * Input: n = 128
     * Output: 1
     * Explanation: The input binary string 10000000 has a total of one set bit.
     *
     * Example 3:
     * Input: n = 2147483645
     * Output: 30
     * Explanation: The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
     *
     * Constraints:
     * 1 <= n <= 2^31 - 1
     *
     * Follow up: If this function is called many times, how would you optimize it?
     *
     * Approach:
     * Iterate through the bits of the integer n. In each iteration, check if the last bit is 1 using the bitwise AND operator (& 1).
     * If it is 1, increment the count. Then, right-shift the integer by 1 bit using the unsigned right shift operator (>>> 1) to process the next bit.
     * Repeat this until the integer becomes 0.
     *
     * Time Complexity: O(number of bits in n), which is O(1) for a fixed size integer like 32-bit.
     * Space Complexity: O(1), as only a constant amount of extra space is used.
     *
     * Optimal Solution (for many calls):
     * Use a lookup table (an array or HashMap) to store the number of set bits for all possible byte values (0 to 255).
     * For a 32-bit integer, divide it into four 8-bit bytes.
     * Look up the number of set bits for each byte from the table and sum them up.
     * This approach can significantly speed up the process if the function is called many times, as the bit counting for each byte is done only once.
     */

     class Solution {
      public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}