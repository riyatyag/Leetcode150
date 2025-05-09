/**
 * Problem Statement: Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.
 * Return the root of the Quad-Tree representing grid.
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
 * isLeaf: True if the node is a leaf node on the tree or False if the node has four children.
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 * 1. If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
 * 2. If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids.
 * 3. Recurse for each of the children with the proper sub-grid.
 *
 * Approach:
 * Recursively divide the grid into four sub-grids. For each sub-grid, check if all the values within it are the same.
 * If they are the same, create a leaf node with the corresponding value.
 * If they are different, create an internal node (isLeaf = false) and recursively construct the four children for the four sub-grids.
 *
 * Time Complexity: O(N^2), where N is the dimension of the n x n grid. In the worst case, we might visit each cell of the grid.
 *
 * Space Complexity: O(log N) in the best case (homogeneous grid) to O(N^2) in the worst case (alternating 0s and 1s), due to the recursion stack and the size of the quad-tree.
 * In the worst case, each 1x1 block becomes a leaf node.
 *
 * Optimal Solution: The recursive approach described is a natural and efficient way to construct the quad-tree based on the problem definition.
 */
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return buildTree(grid, 0, 0, n);
    }

    private Node buildTree(int[][] grid, int rowStart, int colStart, int size) {
        if (size == 0) {
            return null;
        }

        boolean allSame = true;
        int val = grid[rowStart][colStart];

        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if (grid[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                break;
            }
        }

        if (allSame) {
            return new Node(val == 1, true);
        }

        int newSize = size / 2;
        Node topLeft = buildTree(grid, rowStart, colStart, newSize);
        Node topRight = buildTree(grid, rowStart, colStart + newSize, newSize);
        Node bottomLeft = buildTree(grid, rowStart + newSize, colStart, newSize);
        Node bottomRight = buildTree(grid, rowStart + newSize, colStart + newSize, newSize);

        Node root = new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        return root;
    }
}