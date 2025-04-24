// Problem Statement:
// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is defined as a maximal substring of non-space characters.

//  Approach:
// We need to extract the last word from the string and return its length.
// There are two main ways to do this:

//  Optimal Approach (Iterative, O(n)):
// Start iterating from the end of the string.

// Skip trailing spaces.

// Once a letter is found, begin counting characters until the next space or beginning of string.

// Return the count.

// This avoids splitting the string and is more efficient in space.

//  Pseudo Code:

// Initialize length = 0
// Start loop from end of string to beginning:
// If character is not space:
// If length == 0, start counting
// Increment length
// Else if length > 0:
// Break loop (word ended)
// Return length


class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--; // skip trailing spaces
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
















