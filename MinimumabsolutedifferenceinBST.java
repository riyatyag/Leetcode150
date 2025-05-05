/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 * Approach:
 * The minimum difference between two nodes in a BST will occur between adjacent nodes in the inorder traversal of the tree.
 * We perform an inorder traversal of the BST. During the traversal, we keep track of the previously visited node.
 * For each node, if a previous node exists, we calculate the difference between the current node's value and the previous node's value and update the minimum difference found so far.
 *
 * Time Complexity: O(N), where N is the number of nodes in the BST, as we visit each node exactly once.
 * Space Complexity: O(H), where H is the height of the BST, due to the recursive call stack. In the worst case (skewed tree), H can be N, resulting in O(N) space complexity. In the best case (balanced tree), H is log(N), resulting in O(log N) space complexity.
 *
 * Optimal Solution:
 * The provided solution is already optimal in terms of time complexity as it visits each node once. The space complexity is also as good as it can get for a recursive inorder traversal. An iterative inorder traversal can achieve O(1) auxiliary space complexity (excluding the output list if we were storing the inorder traversal), but for finding the minimum difference on the fly, the recursive approach is concise and efficient.
 */
class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inOrder(node.right);
    }
}