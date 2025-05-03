/**
 * Problem Statement: Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Approach (Recursive):
 * The maximum depth of a binary tree can be found recursively.
 * 1. If the root is null, the depth is 0.
 * 2. Otherwise, the maximum depth is 1 (for the current node) plus the maximum depth of either the left subtree or the right subtree.
 * 3. Recursively calculate the depth of the left subtree.
 * 4. Recursively calculate the depth of the right subtree.
 * 5. Return 1 + the maximum of the left depth and the right depth.
 *
 * Approach (Iterative - Breadth-First Search):
 * We can also use Breadth-First Search (BFS) to find the maximum depth.
 * 1. If the root is null, the depth is 0.
 * 2. Initialize a queue with the root node and a depth counter to 0.
 * 3. While the queue is not empty:
 * a. Increment the depth counter.
 * b. Get the number of nodes at the current level.
 * c. Dequeue all the nodes at the current level and enqueue their non-null children.
 * 4. The final value of the depth counter will be the maximum depth.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once in both recursive and iterative approaches.
 *
 * Space Complexity: O(h) for the recursive approach, where h is the height of the tree (due to the call stack). In the worst case (skewed tree), it can be O(n). O(w) for the iterative approach, where w is the maximum width of the tree (due to the queue). In the worst case (complete binary tree), it can be O(n).
 *
 * Optimal Solution: Both recursive and iterative approaches achieve O(n) time complexity. The recursive approach has a space complexity related to the height of the tree, while the iterative approach has a space complexity related to the width of the tree. The recursive solution is often considered slightly simpler to implement for this problem.
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}