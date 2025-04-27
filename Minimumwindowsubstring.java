//  Problem Statement:
// Given two strings `s` and `t`, return the minimum window substring of `s` such that every character in `t` (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".

//  Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

//  Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

//  Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window, but s only has one 'a', so the result is empty.

//  Approach:
// 1. Use a sliding window approach to check every possible substring of `s` and find the one that contains all the characters in `t`.
// 2. Maintain a hash map for the frequency of characters in `t` and another hash map for the characters in the current window.
// 3. Use two pointers: `left` and `right` to expand and shrink the window as we try to find the minimum substring.
 
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> t_count = new HashMap<>();
        for (char c : t.toCharArray()) {
            t_count.put(c, t_count.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window_count = new HashMap<>();
        int left = 0; 
        int right = 0; 
        int required = t_count.size();
        int formed = 0;
        int minLength = Integer.MAX_VALUE; 
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window_count.put(c, window_count.getOrDefault(c, 0) + 1);

            if (t_count.containsKey(c) && window_count.get(c).intValue() == t_count.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                window_count.put(c, window_count.get(c) - 1);
                if (t_count.containsKey(c) && window_count.get(c).intValue() < t_count.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
