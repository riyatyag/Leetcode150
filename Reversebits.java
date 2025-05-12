    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * Note:
     * Note that in some languages, such as Java, there is no unsigned integer type.
     * In this case, both input and output will be given as a signed integer type.
     * They should not affect your implementation, as the integer's internal binary
     * representation is the same, whether it is signed or unsigned.
     * In Java, the compiler represents the signed integers using 2's complement notation.
     * Therefore, in Example 2 above, the input represents the signed integer -3 and
     * the output represents the signed integer -1073741825.
     *
     * Example 1:
     * Input: n = 00000010100101000001111010011100
     * Output:    964176192 (00111001011110000010100101000000)
     * Explanation: The input binary string 00000010100101000001111010011100
     * represents the unsigned integer 43261596, so return 964176192 which its
     * binary representation is 00111001011110000010100101000000.
     *
     * Example 2:
     * Input: n = 11111111111111111111111111111101
     * Output:   3221225471 (10111111111111111111111111111111)
     * Explanation: The input binary string 11111111111111111111111111111101
     * represents the unsigned integer 4294967293, so return 3221225471 which its
     * binary representation is 10111111111111111111111111111111.
     *
     * Constraints:
     * The input must be a binary string of length 32
     *
     * Follow up: If this function is called many times, how would you optimize it?
     *
     * Approach:
     * Iterate 32 times, from the least significant bit to the most significant bit of the input integer.
     * In each iteration, get the last bit of the input integer using the bitwise AND operator (& 1).
     * Shift the result to the left by 1 bit (<<= 1).
     * Set the last bit of the result to the obtained bit using the bitwise OR operator (|=).
     * Shift the input integer to the right by 1 bit using the unsigned right shift operator (>>>= 1).
     * After 32 iterations, the result will contain the reversed bits of the input integer.
     *
     * Time Complexity: O(1), as the loop runs a fixed 32 times regardless of the input.
     * Space Complexity: O(1), as only a constant amount of extra space is used.
     *
     * Optimal Solution (for many calls):
     * Use a cache (e.g., a HashMap) to store the reversed bits of byte-sized chunks (8 bits).
     * When reversing a 32-bit integer, divide it into four 8-bit chunks.
     * Reverse each chunk using the cached results and then combine them in the reversed order.
     * This approach reduces redundant computations if the same byte patterns appear frequently.
     */

     public class Solution {
     public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }
}