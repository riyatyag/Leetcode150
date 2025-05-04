/**
 * Problem Statement: Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Approach:
 * We use Breadth-First Search (BFS) to traverse the tree level by level. A queue holds nodes for the current level.
 * For each level, we process all nodes in the queue, adding their values to a list. Then, we enqueue their children.
 * This ensures that we visit all nodes at the same depth before moving to the next depth.
 *
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, as each node is visited and processed exactly once.
 *
 * Space Complexity: O(W), where W is the maximum width of the binary tree. In the worst-case scenario (a complete binary tree), the queue can hold up to N/2 nodes.
 *
 * Optimal Solution: The BFS approach is optimal for level order traversal in terms of both time and space complexity.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}