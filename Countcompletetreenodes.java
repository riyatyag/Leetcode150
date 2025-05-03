/**
 * Problem Statement: Given the root of a complete binary tree, return the number of the nodes in the tree.
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * Approach:
 * The key to solving this in less than O(n) time lies in the properties of a complete binary tree.
 * In a complete binary tree, all levels except possibly the last are completely filled, and all nodes in the last level are as far left as possible.
 * We can leverage this structure to count nodes more efficiently than a simple traversal.
 *
 * Algorithm:
 * 1. If the root is null, the count is 0.
 * 2. For the given root, calculate the height of the leftmost branch (always full in a complete tree) and the height of the rightmost branch.
 * 3. If the heights of the left and right branches are equal, it means the tree is a perfect binary tree. In this case, the number of nodes is 2^h - 1, where h is the height (number of levels).
 * 4. If the heights are not equal, it means the last level is not completely filled. In this case, we recursively count the nodes in the left subtree and the right subtree and add 1 (for the root).
 *
 * Helper function `getHeightLeft(TreeNode node)`:
 * Calculates the height of the leftmost branch of the subtree rooted at `node`.
 *
 * Helper function `getHeightRight(TreeNode node)`:
 * Calculates the height of the rightmost branch of the subtree rooted at `node`.
 *
 * Main function `countNodes(TreeNode root)`:
 * 1. If `root` is null, return 0.
 * 2. Calculate `heightLeft = getHeightLeft(root)` and `heightRight = getHeightRight(root)`.
 * 3. If `heightLeft == heightRight`, return `(1 << heightLeft) - 1` (which is 2^heightLeft - 1).
 * 4. Otherwise, return `1 + countNodes(root.left) + countNodes(root.right)`.
 *
 * Time Complexity: O((log n)^2). In the worst case, the tree is a complete binary tree that is not a perfect binary tree. For each node, we might calculate the height of its left and right subtrees, which takes O(log n) in a balanced complete tree. Since we do this recursively, and in the worst case, we might traverse down to the leaf nodes, the overall complexity is closer to O((log n)^2).
 *
 * Space Complexity: O(log n) due to the recursive call stack, which is proportional to the height of the tree in a balanced complete tree.
 *
 * Optimal Solution: The recursive approach leveraging the properties of a complete binary tree provides a time complexity better than O(n).
 */
class Solution {
    private int getHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int heightLeft = getHeightLeft(root);
        int heightRight = getHeightRight(root);

        if (heightLeft == heightRight) {
            return (1 << heightLeft) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}