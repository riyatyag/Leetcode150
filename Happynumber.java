// Problem Statement:
// Write an algorithm to determine if a number n is a happy number.
//
// A happy number is defined by the following process:
// 1. Start with any positive integer.
// 2. Replace the number by the sum of the squares of its digits.
// 3. Repeat the process until the number becomes 1 (happy) or loops endlessly in a cycle (not happy).
// Return true if n is a happy number, otherwise return false.
//
//  Example 1:
// Input: n = 19
// Output: true
// Explanation:
// 1² + 9² = 82
// 8² + 2² = 68
// 6² + 8² = 100
// 1² + 0² + 0² = 1 → happy number
//
//  Example 2:
// Input: n = 2
// Output: false

//  Constraints:
// 1 <= n <= 2³¹ - 1

// Approach:
// - Use a HashSet to keep track of numbers we've seen before to detect cycles.
// - Use a helper method `getNext()` to compute the sum of squares of digits.
// - If we reach 1, return true. If we see a repeated number, return false (cycle detected).

//  Time Complexity: O(log n) per digit transformation, but runs only a few iterations in practice
//  Space Complexity: O(log n) to store intermediate values in the set (worst-case)



class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10;
            totalSum += digit * digit;
            num = num / 10;
        }
        return totalSum;
    }
}
