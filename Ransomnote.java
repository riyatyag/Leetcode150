//  Problem Statement:
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed
// by using the letters from magazine and false otherwise.
// Each letter in magazine can only be used once in ransomNote.

//  Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false

//  Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false

// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true

//  Approach:
// 1. Count the frequency of each character in the magazine string.
// 2. For each character in ransomNote, check if it is available in the magazine with the required frequency.
// 3. If at any point a character in ransomNote is not available in magazine, return false.
// 4. If all characters are found in sufficient frequency, return true.

//  Time Complexity: O(m + n), where m is the length of ransomNote and n is the length of magazine. 
// We traverse both strings once to count frequencies and then check the ransomNote against magazine.
//  Space Complexity: O(1), as the frequency array always has a fixed size of 26 (for lowercase letters).

// Code:

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineFreq = new int[26];
        
        for (char c : magazine.toCharArray()) {
            magazineFreq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (magazineFreq[c - 'a'] == 0) {
                return false;  
            }
            magazineFreq[c - 'a']--; 
        }

        return true;  
    }
}
