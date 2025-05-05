/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Approach:
 * We can use an inorder traversal of the tree. For a valid BST, the inorder traversal should yield a strictly increasing sequence of values.
 * We can keep track of the previously visited node's value. For each node, we check if its value is greater than the previous value. If it's not, the tree is not a valid BST.
 * To handle the initial case and the constraint that all nodes in the left subtree must be smaller and all nodes in the right subtree must be larger, we can pass down the valid range (lower and upper bounds) for each subtree.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree, as we visit each node exactly once.
 * Space Complexity: O(H), where H is the height of the tree, due to the recursive call stack. In the worst case (skewed tree), H can be N, resulting in O(N) space complexity. In the best case (balanced tree), H is log(N), resulting in O(log N) space complexity.
 *
 * Optimal Solution:
 * The recursive approach with range checking is a clean and efficient way to validate a BST. An iterative inorder traversal can also be used, keeping track of the previous node's value, which would also have O(N) time complexity and O(H) space complexity (for the stack). The recursive approach is often preferred for its clarity.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }
}