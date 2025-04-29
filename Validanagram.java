//  Problem Statement:
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An anagram is a word formed by rearranging the letters of another, using all the original letters exactly once.

//  Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

//  Constraints:
// 1 <= s.length, t.length <= 5 * 10^4
// s and t consist of lowercase English letters.

//  Follow-up:
// What if the inputs contain Unicode characters? In that case, consider using a HashMap instead of an array.

//  Approach:
// - Use a character count array of size 26 for lowercase English letters.
// - Increment the count for each character in `s`.
// - Decrement the count for each character in `t`.
// - At the end, if all counts are zero, then `t` is an anagram of `s`.

//  Time Complexity: O(n), where n = max(s.length, t.length)
//  Space Complexity: O(1), since the character count array is fixed in size (26)


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
