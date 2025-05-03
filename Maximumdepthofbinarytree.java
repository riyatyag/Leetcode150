/**
 * Problem Statement: Given a binary tree, populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
 *
 * Approach:
 * We can solve this problem using a level-order traversal (BFS). We can use a queue to keep track of the nodes at each level. While processing each level, we can set the 'next' pointers of the nodes.
 * 1. If the root is null, return null.
 * 2. Create a queue and add the root to it.
 * 3. While the queue is not empty:
 * a. Get the number of nodes at the current level.
 * b. Iterate through all the nodes at the current level.
 * c. Dequeue the current node.
 * d. If it's not the last node at the current level, set its 'next' pointer to the next node in the queue.
 * e. Enqueue the left and right children of the current node (if they exist).
 * 4. Return the root.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited and processed exactly once.
 *
 * Space Complexity: O(w), where w is the maximum width of the tree. In the worst case (a complete binary tree), the width of the last level can be n/2, so the space complexity can be O(n). The follow-up asks for constant extra space, which suggests an alternative approach.
 *
 * Optimal Solution (Constant Extra Space - Iterative):
 * We can achieve constant extra space by traversing level by level using the existing 'next' pointers.
 * 1. Start with the root.
 * 2. While there is a leftmost child in the current level (starting from the root):
 * a. Create a 'dummyHead' node for the next level and a 'current' pointer to it.
 * b. Traverse the current level using the 'next' pointers.
 * c. For each node in the current level:
 * i. If it has a left child, set 'current.next' to the left child and move 'current' to the left child.
 * ii. If it has a right child, set 'current.next' to the right child and move 'current' to the right child.
 * d. Move to the next level by setting the root to the 'dummyHead.next'.
 * 3. Return the original root.
 *
 * Time Complexity: O(n), each node is visited and processed.
 * Space Complexity: O(1), constant extra space is used.
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            Node dummyHead = new Node(0);
            Node previous = dummyHead;

            while (current != null) {
                if (current.left != null) {
                    previous.next = current.left;
                    previous = previous.next;
                }
                if (current.right != null) {
                    previous.next = current.right;
                    previous = previous.next;
                }
                current = current.next;
            }
            levelStart = dummyHead.next;
        }

        return root;
    }
}