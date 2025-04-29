//  Problem Statement:
// Given a pattern and a string s, determine if s follows the same pattern.
// There must be a one-to-one mapping between each character in the pattern and each word in the string,
// such that:
// 1. Each character maps to exactly one word.
// 2. Each word maps to exactly one character (bijection).

//  Example 1:
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true
// Explanation: 'a' → "dog", 'b' → "cat"

//  Example 2:
// Input: pattern = "abba", s = "dog cat cat fish"
// Output: false

//  Example 3:
// Input: pattern = "aaaa", s = "dog cat cat dog"
// Output: false

// Constraints:
// - 1 <= pattern.length <= 300
// - 1 <= s.length <= 3000
// - pattern contains only lowercase letters
// - s contains lowercase letters separated by single spaces (no leading/trailing spaces)

//  Approach:
// - Split the string `s` into words.
// - If number of words != pattern length, return false.
// - Use two hash maps:
//     1. `charToWord`: Map each character to a word.
//     2. `wordToChar`: Map each word back to a character.
// - Check and ensure bijection between characters and words.

//  Time Complexity: O(n), where n = number of words in s.
//  Space Complexity: O(n) for storing mappings.



class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;
            } else {
                charToWord.put(c, w);
            }

            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != c) return false;
            } else {
                wordToChar.put(w, c);
            }
        }

        return true;
    }
}
