   /**
     * Problem Statement:
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     *
     * Approach:
     * We can use a backtracking approach to generate all permutations. We maintain a temporary list to store the current permutation being built. For each number in the input array, if it's not already included in the current permutation, we add it to the temporary list and make a recursive call to explore further permutations. Once a complete permutation is formed (i.e., the size of the temporary list equals the size of the input array), we add it to the result list. After the recursive call returns, we backtrack by removing the last added number from the temporary list to explore other possibilities.
     * To keep track of which numbers have been used in the current permutation, we can use a boolean array of the same size as the input array.
     *
     * Time Complexity: O(N!), where N is the number of elements in the input array. This is because there are N! possible permutations, and in the worst case, we might visit each of them.
     *
     * Space Complexity: O(N), due to the space used by the recursion stack, which can go up to N levels, and the temporary list to store the current permutation. The space used to store the final result (the list of all permutations) is also significant but is typically not considered in the auxiliary space complexity.
     *
     * Optimal Solution:
     * The backtracking approach is a standard and efficient way to generate all permutations of a distinct set of elements. Given the constraints (n <= 6), the O(N!) time complexity is acceptable.
     */
    import java.util.ArrayList;
    import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}