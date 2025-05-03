/**
 * Problem Statement: Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Approach (Recursive):
 * 1. If both p and q are null, they are the same.
 * 2. If one of p or q is null, they are not the same.
 * 3. If the values of the root nodes of p and q are not equal, they are not the same.
 * 4. Recursively check if the left subtrees of p and q are the same.
 * 5. Recursively check if the right subtrees of p and q are the same.
 * 6. The two trees are the same if and only if all the above conditions are met.
 *
 * Approach (Iterative - Breadth-First Search):
 * 1. If both p and q are null, they are the same.
 * 2. If one of p or q is null, they are not the same.
 * 3. Create a queue and add both p and q to it.
 * 4. While the queue is not empty:
 * a. Dequeue two nodes, n1 and n2.
 * b. If both n1 and n2 are null, continue.
 * c. If one of n1 or n2 is null, return false.
 * d. If the values of n1 and n2 are not equal, return false.
 * e. Enqueue the left children of n1 and n2.
 * f. Enqueue the right children of n1 and n2.
 * 5. If the loop finishes without returning false, the two trees are the same.
 *
 * Time Complexity: O(n), where n is the number of nodes in the smaller tree. In the worst case, we might need to compare all nodes of both trees.
 *
 * Space Complexity: O(h) for the recursive approach, where h is the height of the deeper tree (due to the call stack). In the worst case (skewed tree), it can be O(n). O(w) for the iterative approach, where w is the maximum width of the trees (due to the queue). In the worst case (complete binary trees), it can be O(n).
 *
 * Optimal Solution: Both recursive and iterative approaches achieve O(n) time complexity. The space complexity differs based on the tree structure and the chosen method.
 **/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }

            queue.offer(n1.left);
            queue.offer(n2.left);
            queue.offer(n1.right);
            queue.offer(n2.right);
        }
        return true;
    }
}