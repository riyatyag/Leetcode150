//  Problem Statement:
// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if characters in s can be replaced to get t, with a one-to-one mapping.

//  Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Explanation: 'e' → 'a', 'g' → 'd'

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false
// Explanation: 'o' can't map to both 'a' and 'r'

//  Example 3:
// Input: s = "paper", t = "title"
// Output: true
// Explanation: 'p'→'t', 'a'→'i', 'e'→'l', 'r'→'e'

// Constraints:
// - 1 <= s.length <= 5 * 10^4
// - t.length == s.length
// - s and t consist of valid ASCII characters.

//  Approach (Two hash maps using arrays):
// - Use two arrays to store the mapping of characters from s to t and vice versa.
// - If the mapping doesn't match at any position, return false.

//  Time Complexity: O(n), where n is the length of the strings
//  Space Complexity: O(1), constant space (since ASCII size is fixed: 256)

// Code:

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapST = new int[256];
        int[] mapTS = new int[256]; 

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapST[sc] == 0 && mapTS[tc] == 0) {
                mapST[sc] = tc;
                mapTS[tc] = sc;
            }
            else if (mapST[sc] != tc || mapTS[tc] != sc) {
                return false;
            }
        }

        return true;
    }
}
