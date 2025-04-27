//  Problem Statement:
// Given a string `s`, find the length of the longest substring without repeating characters.

//  Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The longest substring without repeating characters is "abc", with the length of 3.

//  Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The longest substring without repeating characters is "b", with the length of 1.

//  Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The longest substring without repeating characters is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence, not a substring.

//  Approach (Sliding Window + HashSet):
// 1. Use the sliding window technique where you maintain a window (substring) of unique characters.
// 2. Use two pointers, `left` and `right`, to track the window and a `HashSet` to store characters that are currently in the window.
// 3. If a duplicate character is encountered, move the `left` pointer right until the window contains no duplicates.
// 4. Keep track of the maximum length of the window during the iteration.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (right < s.length()) {
            char current = s.charAt(right);
            
            if (!set.contains(current)) {
                set.add(current);
                maxLen = Math.max(maxLen, right - left + 1); 
                right++; 
            } 
            else {
                set.remove(s.charAt(left));
                left++; 
            }
        }
        
        return maxLen; 
    }
}
