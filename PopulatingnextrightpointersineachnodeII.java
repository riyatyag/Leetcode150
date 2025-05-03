/**
 * Problem Statement: Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Approach (Recursive):
 * The last element in the postorder traversal is always the root of the tree.
 * The position of the root in the inorder traversal divides the inorder array into two parts: the left subtree and the right subtree.
 * We can recursively build the left and right subtrees using the remaining elements of the postorder and the corresponding parts of the inorder array.
 *
 * 1. Create a helper function `buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, Map<Integer, Integer> inorderMap)`.
 * 2. The `inorderMap` will store the index of each element in the inorder array for efficient lookups.
 * 3. Base case: If `inorderStart > inorderEnd` or `postorderStart > postorderEnd`, return null (empty subtree).
 * 4. The root of the current subtree is the element at `postorder[postorderEnd]`. Create a new `TreeNode` with this value.
 * 5. Find the index of the root value in the `inorder` array using the `inorderMap` (`rootIndex`).
 * 6. The number of nodes in the left subtree is `rootIndex - inorderStart`.
 * 7. Recursively build the left subtree: `root.left = buildTreeHelper(inorder, postorder, inorderStart, rootIndex - 1, postorderStart, postorderStart + leftSubtreeSize - 1, inorderMap)`.
 * 8. Recursively build the right subtree: `root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inorderEnd, postorderStart + leftSubtreeSize, postorderEnd - 1, inorderMap)`.
 * 9. Return the constructed `root`.
 *
 * Main function `buildTree(int[] inorder, int[] postorder)`:
 * 1. Create the `inorderMap`.
 * 2. Call the `buildTreeHelper` function with the initial ranges of the inorder and postorder arrays (0 to length - 1).
 *
 * Time Complexity: O(n), where n is the number of nodes in the tree. Each node is created once, and we iterate through the arrays once to build the inorder map and in the recursive calls.
 *
 * Space Complexity: O(n) in the worst case due to the recursion stack (in a skewed tree) and the space used by the `inorderMap`.
 *
 * Optimal Solution: The recursive approach with the inorder map provides an efficient way to construct the binary tree in O(n) time.
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, Map<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        int rootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);
        int leftSubtreeSize = rootIndex - inorderStart;

        root.left = buildTreeHelper(inorder, postorder, inorderStart, rootIndex - 1, postorderStart, postorderStart + leftSubtreeSize - 1, inorderMap);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inorderEnd, postorderStart + leftSubtreeSize, postorderEnd - 1, inorderMap);

        return root;
    }
}