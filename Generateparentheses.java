/**
     * Problem Statement:
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Approach:
     * We can use a recursive backtracking approach. We maintain a string that represents the current combination of parentheses being built. We also keep track of the number of open and closed parentheses used so far.
     * At each step, we have two choices:
     * 1. Add an open parenthesis '(' if the number of open parentheses used is less than n.
     * 2. Add a closed parenthesis ')' if the number of closed parentheses used is less than the number of open parentheses used. This ensures that we never have more closing parentheses than opening parentheses, which is a requirement for well-formed parentheses.
     * The base case for the recursion is when the length of the current string is equal to 2 * n (meaning we have used all n pairs of parentheses). At this point, the current string represents a well-formed combination, so we add it to our result list.
     *
     * Time Complexity: O(4^n / sqrt(n)). This is related to the nth Catalan number, as the number of valid parentheses combinations is the nth Catalan number, and the generation process explores a tree where each node can have up to two branches.
     *
     * Space Complexity: O(n). This is due to the depth of the recursion stack, which can go up to 2n in the worst case, and the space used to store each valid combination of parentheses, which has a length of 2n. However, if we consider the space for the output list, the space complexity would be proportional to the number of valid combinations (Catalan number).
     *
     * Optimal Solution:
     * The backtracking approach used here is generally considered the most straightforward and efficient way to generate all well-formed parentheses. While there might be slight variations or optimizations, the core idea of recursively building the strings while maintaining the validity conditions remains the same.
     */
    import java.util.ArrayList;
    import java.util.List;
    class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }
}