/**
 * Problem Statement: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Approach:
 * The problem can be solved using a recursive approach. The base cases are:
 * 1. If the current node is null, return null.
 * 2. If the current node is either p or q, then this node is an ancestor of p and q (including the case where a node is a descendant of itself), so we return the current node.
 *
 * For the recursive step, we traverse the left and right subtrees.
 * - If both the left and right subtree calls return a non-null node, it means p is in one subtree and q is in the other. Therefore, the current node is the LCA.
 * - If only one of the subtree calls returns a non-null node, it means both p and q are in that subtree, and the non-null node returned is the LCA.
 * - If both subtree calls return null, it means neither p nor q are in the current subtree, so we return null.
 *
 * Time Complexity: O(N), where N is the number of nodes in the binary tree. In the worst case, we might visit all nodes.
 *
 * Space Complexity: O(H), where H is the height of the binary tree. This is due to the recursive call stack. In the worst case of a skewed tree, H can be N, leading to O(N) space complexity. In the best case of a balanced tree, H is log N, leading to O(log N) space complexity.
 *
 * Optimal Solution: The recursive approach described above is an optimal solution in terms of time complexity.
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}