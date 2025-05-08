/**
     * Problem Statement:
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons) is provided. Note that 1 does not map to any letters.
     *
     * Approach:
     * We can use a backtracking approach to generate all possible letter combinations. We will iterate through the digits of the input string. For each digit, we will look up the corresponding letters from the provided mapping. Then, we will recursively explore all possible combinations by appending each letter to the current combination being built.
     * The backtracking function will take the input digits string, the current index of the digit being processed, the current combination string being built, the list to store the final results, and the mapping of digits to letters as parameters.
     * The base case for the recursion is when the current index reaches the end of the digits string. At this point, the current combination string is complete, so we add it to the result list.
     * In the recursive step, we get the letters corresponding to the digit at the current index. We then iterate through each letter in this set of letters. For each letter, we append it to the current combination and make a recursive call for the next digit in the input string (index + 1). After the recursive call returns, we don't need to explicitly backtrack by removing the last added letter because in Java, strings are immutable, so each recursive call works with a new, extended string.
     *
     * Time Complexity: O(4^N * N), where N is the length of the input digits string. In the worst case, each digit maps to 4 letters (for digits 7 and 9), so there are 4^N possible combinations. For each combination, we need O(N) time to build the string.
     *
     * Space Complexity: O(N), due to the depth of the recursion stack, which can go up to N levels (equal to the length of the digits string). The space used to store the final result (the list of all combinations) is also significant but is typically not considered in the auxiliary space complexity.
     *
     * Optimal Solution:
     * The backtracking approach is a standard and efficient way to solve this problem given the small constraint on the length of the input digits (up to 4).
     **/
    import java.util.ArrayList;
    import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        String[] mappings = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(digits, 0, new StringBuilder(), result, mappings);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result, String[] mappings) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = mappings[digit - '0'];
        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, index + 1, currentCombination, result, mappings);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}