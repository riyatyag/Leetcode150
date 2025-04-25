// Problem Statement:
// Given a string `s`, reverse the order of the words.
// A word is defined as a sequence of non-space characters.
// Return a new string with the words in reverse order, separated by a single space.
// The result must not contain leading, trailing, or multiple spaces between words.

//  Constraints:
// 1. Input string may have leading/trailing spaces.
// 2. There may be multiple spaces between words.
// 3. You must return a string with exactly one space between each word and no extra spaces.

//  Optimal Approach:
// 1. Trim the string to remove leading/trailing spaces.
// 2. Use regex "\\s+" to split the string by one or more spaces.
// 3. Reverse the array of words.
// 4. Join them using a single space to build the final result.

//  Time Complexity: O(n) → for traversing and reversing the words
//  Space Complexity: O(n) → for storing split words and the final result

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
