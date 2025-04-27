//  Problem Statement:
// Given a string `s` and an array of strings `words`, return an array of starting indices of all the concatenated substrings in `s`.
// A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

//  Example 1:
// Input: s = "barfoothefoobarman", words = ["foo","bar"]
// Output: [0,9]
// Explanation: The substring starting at index 0 is "barfoo", and starting at index 9 is "foobar", both of which are permutations of words.

//  Example 2:
// Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
// Output: []
// Explanation: There is no valid concatenated substring.

//  Example 3:
// Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// Output: [6,9,12]
// Explanation: There are 3 concatenated substrings: "foobarthe", "barthefoo", and "thefoobar".

//  Approach:
// 1. First, we calculate the total length of the concatenated string by multiplying the length of each word by the number of words.
// 2. Use a sliding window approach to check each substring of the calculated total length.
// 3. For each window, check if the substring is a permutation of the given words. We can use a hash map to track the frequency of the words in the window.
// 4. Return the starting indices where the concatenation of words is found.

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int word_len = words[0].length();  
        int num_words = words.length;     
        int total_len = word_len * num_words;  
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < word_len; i++) { 
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            while (right + word_len <= s.length()) {
                String word = s.substring(right, right + word_len);
                right += word_len;

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);

                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + word_len);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += word_len;
                    }

                    if (right - left == total_len) {
                        result.add(left);
                    }
                } else {
                    currentCount.clear();
                    left = right;
                }
            }
        }

        return result; 
    }
}
