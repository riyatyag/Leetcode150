/**
     * Problem Statement:
     * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
     * You may return the answer in any order. Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
     *
     * Approach:
     * We can use a backtracking approach to generate all combinations. We maintain a temporary list to store the current combination being built. We iterate through the numbers from the starting point up to n. For each number, we include it in the current combination and make a recursive call to find the remaining k-1 numbers. To avoid duplicate combinations (e.g., [1,2] and [2,1]), we ensure that in each recursive call, we only consider numbers that are greater than the last number added to the current combination. This is achieved by passing the current number + 1 as the starting point for the next recursive call.
     * The backtracking function will take n, k, the starting number for the current level, the current combination being built, and the list to store the final results as parameters.
     * The base case for the recursion is when the size of the current combination becomes equal to k. At this point, we have found a valid combination, so we add a copy of it to the result list.
     * In the recursive step, we iterate from the starting number up to n. For each number, we add it to the current combination and make a recursive call with the starting number incremented by 1 and k decremented by 1. After the recursive call returns, we backtrack by removing the last added number from the current combination to explore other possibilities.
     *
     * Time Complexity: O(C(n, k) * k), where C(n, k) is the number of combinations of choosing k elements from n. This is because we generate each combination and then add it to the result list, which takes O(k) time in the worst case (to create a new list).
     *
     * Space Complexity: O(k), due to the space used by the recursion stack, which can go up to k levels in the worst case (when k is close to n), and the temporary list to store the current combination. The space used to store the final result (the list of all combinations) is also significant but is typically not considered in the auxiliary space complexity.
     *
     * Optimal Solution:
     * The backtracking approach is a standard and efficient way to generate combinations. The use of a starting index in the recursive calls effectively prevents the generation of duplicate combinations.
     */

     import java.util.ArrayList;
     import java.util.List;

class Solution { 
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}