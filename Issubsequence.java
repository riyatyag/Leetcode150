// ✅ Problem Statement:
// Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise.
// A subsequence of a string is a new string formed by deleting some (or no) characters 
// from the original string without disturbing the relative order of the remaining characters.

// ✅ Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true
// Explanation: You can form "abc" by deleting 'h', 'g', and 'd' from "ahbgdc".

// ✅ Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false
// Explanation: You cannot form "axc" as 'x' does not appear after 'a' in t.

// ✅ Approach:
// 1. Use two pointers: one pointer `i` for string `s` and one pointer `j` for string `t`.
// 2. Traverse `t` from left to right.
//    - If the characters at `s[i]` and `t[j]` match, move the `i` pointer forward (i.e., found a matching character).
//    - Always move the `j` pointer forward (i.e., checking next character in `t`).
// 3. After the loop:
//    - If `i == s.length()`, it means we have matched all characters of `s` in `t` maintaining the order → return true.
//    - Otherwise, return false.

// ✅ Pseudo Code:
// - Initialize i = 0, j = 0
// - While i < s.length() and j < t.length():
//     - If s[i] == t[j], increment i
//     - Increment j
// - Return i == s.length()

// ✅ Time Complexity: O(n)
// where n = length of t, because in worst case we go through all characters of t once.

// ✅ Space Complexity: O(1)
// Only using two integer pointers, no extra space.

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
