/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Approach:
 * We can perform an inorder traversal of the Binary Search Tree (BST). In an inorder traversal, the nodes are visited in ascending order.
 * We maintain a counter to keep track of the number of nodes visited. When the counter reaches k, the current node's value is the kth smallest element.
 *
 * Time Complexity: O(N) in the worst case (e.g., a skewed tree where we might visit all nodes). However, in the best case where the kth smallest element is found early in the traversal, it could be O(K).
 * Space Complexity: O(H), where H is the height of the BST, due to the recursive call stack. In the worst case (skewed tree), H can be N, resulting in O(N) space complexity. In the best case (balanced tree), H is log(N), resulting in O(log N) space complexity.
 *
 * Optimal Solution:
 * The inorder traversal approach is optimal in terms of the fundamental operation needed (visiting nodes in sorted order). We can optimize the space complexity to O(1) using an iterative inorder traversal with a stack, which can be beneficial for very deep trees.
 *
 * Follow-up optimization for frequent modifications:
 * If the BST is modified frequently (insertions and deletions) and we need to find the kth smallest element often, a more efficient approach would be to augment the BST. We can add an extra field to each node that stores the number of nodes in its left subtree (including itself).
 * With this augmentation, we can find the kth smallest element in O(H) time, where H is the height of the tree. The update operations (insert and delete) would also need to maintain this count, which can be done in O(H) time as well. This trade-off of extra space for faster queries is suitable for frequent kth smallest operations.
 */
class Solution {
    private int count = 0;
    private int kthSmallestValue = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kthSmallestValue;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        inorder(node.left, k);

        count++;
        if (count == k) {
            kthSmallestValue = node.val;
            return;
        }

        inorder(node.right, k);
    }
}