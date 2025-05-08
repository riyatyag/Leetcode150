    /**
     * Problem Statement:
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     * Approach:
     * We will iterate through each cell of the board. If the character in the current cell matches the first character of the word, we will initiate a Depth First Search (DFS) from this cell to find the remaining characters of the word in adjacent cells.
     * The DFS function will take the board, current row and column, the word, and the current index of the word being searched as parameters.
     * In the DFS function, we will check the base cases:
     * 1. If the current index of the word is equal to the length of the word, it means we have found the entire word, so we return true.
     * 2. If the current row or column is out of bounds or the character in the current cell does not match the character at the current index in the word, we return false.
     * To avoid reusing the same cell, we will temporarily mark the current cell as visited (e.g., by changing its value to a special character). After the recursive calls, we will backtrack by restoring the original character of the cell.
     * We will explore the four neighboring cells (up, down, left, right) recursively. If any of these recursive calls return true, it means we have found the word.
     * If after iterating through all the cells in the board, we do not find the word, we return false.
     *
     * Time Complexity: O(M * N * 4^L), where M is the number of rows, N is the number of columns, and L is the length of the word. In the worst case, we might start a DFS from each cell, and for each character in the word, we explore up to 4 directions.
     *
     * Space Complexity: O(L), where L is the length of the word. This is due to the recursion stack in the DFS function.
     *
     * Optimal Solution:
     * The provided solution using DFS with backtracking is a standard and efficient approach for this problem given the constraints. Search pruning as suggested in the follow-up could involve optimizations like checking if the count of each character in the board is sufficient for the word before starting the search, but the core DFS approach remains the same.
     */
    class Solution {
     public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = dfs(board, row + 1, col, word, index + 1) ||
                        dfs(board, row - 1, col, word, index + 1) ||
                        dfs(board, row, col + 1, word, index + 1) ||
                        dfs(board, row, col - 1, word, index + 1);
        board[row][col] = temp;
        return found;
    }
}