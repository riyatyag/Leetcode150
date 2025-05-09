/**
 * Problem Statement: Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * Approach: Recursively construct the BST. The middle element of the sorted array will be the root of the current subtree.
 * The left subtree will be constructed from the left half of the array, and the right subtree will be constructed from the right half.
 *
 * Time Complexity: O(n), where n is the number of elements in the array. Each element is visited and processed exactly once.
 *
 * Space Complexity: O(log n) in the average case due to the recursion stack for a balanced tree. In the worst case (skewed tree), it can be O(n). The space used for the output tree is not considered in the space complexity of the algorithm itself.
 *
 * Optimal Solution: The recursive approach of selecting the middle element as the root ensures the height-balanced property and achieves linear time complexity.
 */
class TreeNode {
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

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}