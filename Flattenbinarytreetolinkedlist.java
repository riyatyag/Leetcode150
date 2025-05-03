/**
 * Problem Statement: Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Approach (Recursive):
 * We can perform a preorder traversal of the tree. During the traversal, we need to rearrange the pointers to form the linked list.
 * For each node, we first process the left subtree, then the right subtree. After processing, we need to connect the flattened left subtree to the current node's right, and the flattened right subtree to the end of the flattened left subtree.
 *
 * Recursive function `flattenHelper(TreeNode node)`:
 * 1. Base case: If the node is null, return null.
 * 2. Recursively flatten the left subtree.
 * 3. Recursively flatten the right subtree.
 * 4. If the left subtree is not null:
 * a. Store the original right child of the current node.
 * b. Make the left subtree the right child of the current node.
 * c. Set the left child of the current node to null.
 * d. Traverse to the end of the flattened left subtree.
 * e. Connect the original right child to the end of the flattened left subtree.
 * 5. Return the (possibly modified) current node.
 *
 * Main function `flatten(TreeNode root)`:
 * 1. Call the `flattenHelper` function with the root.
 *
 * Approach (Iterative):
 * We can also solve this iteratively using a stack. The idea is to simulate the preorder traversal.
 * 1. Initialize a stack with the root node.
 * 2. While the stack is not empty:
 * a. Pop the current node from the stack.
 * b. If the right child exists, push it onto the stack (as it will be visited later).
 * c. If the left child exists, push it onto the stack (as it will be visited next).
 * d. If the stack is not empty, make the top of the stack the right child of the current node.
 * e. Set the left child of the current node to null.
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited and its pointers are modified exactly once.
 *
 * Space Complexity: O(h) for the recursive approach in the worst case (skewed tree), due to the recursion stack. O(h) for the iterative approach in the worst case (skewed tree), due to the stack. In the best case (balanced tree), the space complexity is O(log n). The follow-up asks for O(1) extra space, which implies an in-place modification without using extra data structures like a stack or recursion stack explicitly.
 *
 * Optimal Solution (In-place):
 * We can achieve O(1) extra space by traversing the tree and rearranging the pointers.
 * 1. Start with the root.
 * 2. While the current node is not null:
 * a. If the current node has a left child:
 * i. Find the rightmost node in the left subtree.
 * ii. Make the current node's right child the right child of the rightmost node in the left subtree.
 * iii. Make the left child of the current node the right child of the current node.
 * iv. Set the left child of the current node to null.
 * b. Move to the right child of the current node.
 *
 * Time Complexity of Optimal Solution: O(n), as each node is visited and its pointers are modified at most twice.
 *
 * Space Complexity of Optimal Solution: O(1), as we are modifying the tree in-place without using any extra data structures.
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}