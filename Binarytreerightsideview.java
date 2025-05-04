/**
 * Problem Statement: Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Approach:
 * We can use Breadth-First Search (BFS) to traverse the tree level by level. For each level, the rightmost
 * node will be the last node we process in the queue for that level. We will add the value of this last
 * node to our result list.
 *
 * Time Complexity: O(N), where N is the number of nodes in the binary tree, as we visit each node once.
 *
 * Space Complexity: O(W), where W is the maximum width of the binary tree, as the queue can hold at most W nodes at any level.
 *
 * Optimal Solution: The BFS approach described is optimal for this problem in terms of time and space complexity.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
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