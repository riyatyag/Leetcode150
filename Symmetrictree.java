/**
 * Problem Statement: Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Approach (Recursive):
 * 1. The root itself is always symmetric. We need to check if the left subtree is a mirror of the right subtree.
 * 2. Create a helper function `isMirror(TreeNode left, TreeNode right)` that takes the left and right subtrees as input.
 * 3. Base cases for `isMirror`:
 * - If both `left` and `right` are null, they are mirrors.
 * - If one of `left` or `right` is null, they are not mirrors.
 * - If the values of `left` and `right` are not equal, they are not mirrors.
 * 4. Recursively check if the left child of `left` is a mirror of the right child of `right`, AND if the right child of `left` is a mirror of the left child of `right`.
 * 5. The main function `isSymmetric(TreeNode root)` will call `isMirror(root.left, root.right)`.
 *
 * Approach (Iterative - Breadth-First Search):
 * 1. If the root is null, it's symmetric.
 * 2. Create a queue and add the left and right children of the root to it (if they exist).
 * 3. While the queue is not empty, dequeue two nodes at a time (representing nodes that should be mirrors of each other).
 * 4. Check the following conditions for the dequeued nodes:
 * - If both are null, continue.
 * - If one is null, return false.
 * - If their values are not equal, return false.
 * 5. Enqueue the outer children (left of the left, right of the right) and the inner children (right of the left, left of the right) in pairs.
 * 6. If the loop finishes without returning false, the tree is symmetric.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited and compared at most once.
 *
 * Space Complexity: O(h) for the recursive approach, where h is the height of the tree (due to the call stack). In the worst case (skewed tree), it can be O(n). O(w) for the iterative approach, where w is the maximum width of the tree (due to the queue). In the worst case (complete binary tree), it can be O(n).
 *
 * Optimal Solution: Both recursive and iterative approaches achieve O(n) time complexity. The space complexity differs based on the tree structure and the chosen method.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}