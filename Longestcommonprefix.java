//  Problem Statement:
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

//  Approach:
// The problem can be solved by comparing characters of each string with the first string in the list. We keep reducing the prefix as we go along.

//  Optimal Approach (Iterative):
// Start with the first string as the initial prefix.

// Iterate through all the strings in the array:

// While the current string doesn't start with the prefix, reduce the prefix by removing the last character.

// If the prefix becomes empty, return "" because no common prefix exists.

// Return the final prefix.

// This approach ensures that we check all strings for the longest common prefix and reduce the prefix progressively.

//  Pseudo Code:

// If input list is empty, return ""
// Set prefix as the first string
// For each string in the list:
//     While current string does not start with the prefix:
//         Remove the last character from prefix
//         If prefix becomes empty, return ""
// Return prefix



class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}
