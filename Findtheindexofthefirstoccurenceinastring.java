// Problem Statement:
// You are given two strings `haystack` and `needle`.
// You have to return the index of the first occurrence of `needle` in `haystack`.
// If `needle` is not found in `haystack`, return -1.

//  Example 1:
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" appears at index 0 and 6, but the first occurrence is at 0.

//  Example 2:
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" does not exist in "leetcode", so return -1.

//  Approach:
// 1. Use the built-in method `indexOf()` in Java's String class.
// 2. It automatically returns the first index of the `needle` in `haystack`.
// 3. If `needle` is not found, it returns -1.

//  Pseudo Code:
// - return haystack.indexOf(needle);

//  Time Complexity: O(n * m) in the worst case,
// where n = length of `haystack`, m = length of `needle`.
// In practice, Java's implementation is optimized for performance.

//  Space Complexity: O(1), no extra space is used.

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

