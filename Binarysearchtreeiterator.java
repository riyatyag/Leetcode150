/**
 * Problem Statement: Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST).
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 *
 * Approach:
 * We need to simulate the in-order traversal of the BST. An in-order traversal visits nodes in the order: Left -> Root -> Right.
 * To achieve average O(1) time complexity for next() and O(h) memory, where h is the height of the tree, we can use a stack to keep track of the nodes.
 *
 * Constructor (BSTIterator(TreeNode root)):
 * Initialize an empty stack.
 * Push all the left children of the root onto the stack until we reach a null left child. This ensures that the smallest elements are at the top of the stack.
 *
 * hasNext():
 * Return true if the stack is not empty, indicating that there are more nodes to visit in the in-order traversal.
 *
 * next():
 * 1. Pop the top node from the stack. This is the next smallest element in the BST.
 * 2. Store the value of the popped node.
 * 3. If the popped node has a right child, move to the right child.
 * 4. From the right child, push all its left children onto the stack until we reach a null left child. This prepares the stack for the next smallest elements in the right subtree.
 * 5. Return the stored value of the popped node.
 *
 * Time Complexity:
 * - Constructor: O(h) in the worst case (skewed tree), as we might push all nodes on one side onto the stack.
 * - hasNext(): O(1), as it's just a stack emptiness check.
 * - next(): Average O(1). While in the worst case (e.g., a right-skewed tree), it might take O(h) to push left children, over a sequence of calls, each node is visited and processed exactly once. Thus, the amortized time complexity for next() is O(1).
 *
 * Space Complexity: O(h), where h is the height of the tree, as the stack will store at most h nodes. In the worst case (skewed tree), h can be n, so the space complexity is O(n).
 *
 * Optimal Solution: The stack-based approach achieves the follow-up requirements of average O(1) time for next() and O(h) memory.
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftSubtree(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushLeftSubtree(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftSubtree(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */