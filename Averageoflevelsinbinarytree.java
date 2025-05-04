/**
 * Problem Statement: Given the root of a binary tree, return the average value of the nodes on each level
 * in the form of an array. Answers within 10^-5 of the actual answer will be accepted.
 *
 * Approach:
 * We perform a Breadth-First Search (BFS) to iterate through the tree level by level. For each level,
 * we calculate the sum of the node values and the count of nodes at that level. The average is then
 * computed by dividing the sum by the count. These averages are stored in a list and finally converted
 * to a double array for the result.
 *
 * Time Complexity: O(N), where N is the total number of nodes in the binary tree, as each node is visited once.
 *
 * Space Complexity: O(W), where W is the maximum width of the binary tree. The queue used in BFS can hold
 * at most the number of nodes at the widest level. In a complete binary tree, this can be up to N/2.
 *
 * Optimal Solution: The BFS approach is efficient and optimal for this problem in terms of both time and space.
 */
 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public double[] averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        if (root == null) {
            return new double[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            averages.add(sum / levelSize);
        }
        double[] result = new double[averages.size()];
        for (int i = 0; i < averages.size(); i++) {
            result[i] = averages.get(i);
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