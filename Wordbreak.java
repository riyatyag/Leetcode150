/**
     * Problem Statement:
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * Approach:
     * This problem can be solved using dynamic programming. Let dp[i] be a boolean value indicating whether the prefix of the string s of length i can be segmented into words from the dictionary.
     * dp[0] is true because an empty string can be segmented.
     * For each i from 1 to n (length of s), we iterate through all possible split points j from 0 to i-1.
     * If dp[j] is true (meaning the prefix of length j can be segmented) and the substring s.substring(j, i) is present in the word dictionary, then dp[i] is true.
     * We use a HashSet for the word dictionary to allow for efficient lookups.
     *
     * Time Complexity: O(n^2 * m), where n is the length of the string s and m is the average length of the words in wordDict. The outer loop runs n times, the inner loop runs up to n times, and the substring operation takes O(m) in the worst case. However, with the HashSet lookup being O(1) on average, the complexity is closer to O(n^2).
     * Space Complexity: O(n + k), where n is the length of the dp array and k is the total number of characters in the word dictionary stored in the HashSet.
     *
     * Optimal Solution:
     */
    import java.util.HashSet;
    import java.util.List;
    class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}