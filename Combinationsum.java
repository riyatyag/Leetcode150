  /**
     * Problem Statement:
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     *
     * Approach:
     * We can use a backtracking approach to find all unique combinations. We will iterate through the candidates array. For each candidate, we have two choices: either include it in the current combination or exclude it. If we include it, we can include it again if the remaining target is still non-negative.
     * To avoid duplicate combinations, we can maintain the order of the candidates. When we make a recursive call, we will only consider the current candidate and the candidates that appear after it in the sorted array. This ensures that we don't generate the same combination with the numbers in a different order.
     * The backtracking function will take the candidates array, the remaining target, the starting index in the candidates array, the current combination being built, and the list to store the final results as parameters.
     * The base cases for the recursion are:
     * 1. If the remaining target becomes 0, it means we have found a valid combination, so we add a copy of the current combination to the result list.
     * 2. If the remaining target becomes negative, it means the current path cannot lead to a valid combination, so we backtrack.
     * In the recursive step, we iterate from the starting index to the end of the candidates array. For each candidate at the current index, we include it in the current combination and make a recursive call with the updated remaining target (target - candidate), and the same index (since we can use the same number multiple times). After the recursive call returns, we backtrack by removing the last added candidate from the current combination to explore other possibilities.
     * Sorting the candidates array initially helps in pruning the search space and avoiding duplicate combinations.
     *
     * Time Complexity: O(N^(target/min(candidates))), where N is the number of candidates. In the worst case, if the smallest candidate is 1 and the target is large, the recursion tree can be quite deep. However, given the constraint that the number of unique combinations is less than 150, the actual runtime will be much better.
     *
     * Space Complexity: O(target/min(candidates)), due to the depth of the recursion stack, which can go up to target/min(candidates) in the worst case. Additionally, we need space to store the resulting combinations.
     *
     * Optimal Solution:
     * The backtracking approach with sorting to handle duplicates is a standard and effective way to solve this problem. The constraints on the number of combinations suggest that a straightforward backtracking solution will perform adequately.
     */
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remaining < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}