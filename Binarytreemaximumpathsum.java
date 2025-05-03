/**
 * Problem Statement: Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 *
 * Approach (Recursive):
 * We can use a recursive depth-first search (DFS) approach. We start from the root and keep track of the current sum of the path.
 * When we move to a child node, we subtract the child's value from the remaining target sum.
 * If we reach a leaf node, we check if the remaining target sum is 0. If it is, it means we have found a root-to-leaf path with the desired sum.
 *
 * Recursive function `hasPathSumHelper(TreeNode node, int remainingSum)`:
 * 1. Base case: If the node is null, return false.
 * 2. Subtract the current node's value from the `remainingSum`.
 * 3. If the current node is a leaf (both left and right children are null), return true if the `remainingSum` is 0, otherwise return false.
 * 4. Recursively call the helper function for the left child and the right child with the updated `remainingSum`. Return true if either of the recursive calls returns true.
 *
 * Main function `hasPathSum(TreeNode root, int targetSum)`:
 * 1. If the root is null, return false (as there is no path).
 * 2. Call the `hasPathSumHelper` function starting from the root with the initial `targetSum`.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. In the worst case, we might visit all nodes.
 *
 * Space Complexity: O(h), where h is the height of the tree, due to the recursive call stack. In the worst case (skewed tree), h can be n, so the space complexity is O(n).
 *
 * Optimal Solution: The recursive DFS approach is an efficient way to solve this problem with a time complexity of O(n).
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, targetSum);
    }

    private boolean hasPathSumHelper(TreeNode node, int remainingSum) {
        remainingSum -= node.val;

        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }

        boolean leftPath = false;
        if (node.left != null) {
            leftPath = hasPathSumHelper(node.left, remainingSum);
        }

        boolean rightPath = false;
        if (node.right != null) {
            rightPath = hasPathSumHelper(node.right, remainingSum);
        }

        return leftPath || rightPath;
    }
}