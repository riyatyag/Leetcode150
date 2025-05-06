    /**
     * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * Region: To form a region connect every 'O' cell.
     * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
     * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
     *
     * Approach:
     * The key idea is to identify the 'O's that are connected to the boundary. These 'O's and the regions they form should not be flipped to 'X'.
     * We can use Depth First Search (DFS) or Breadth First Search (BFS) starting from all the 'O's on the border of the grid.
     * Mark these 'O's (and all 'O's connected to them) with a temporary character (e.g., '#').
     * After marking all the non-surrounded 'O's, iterate through the grid.
     * All the 'O's remaining in the grid are the surrounded regions, so flip them to 'X'.
     * Finally, change the temporary '#' back to 'O' for the 'O's that were connected to the border.
     *
     * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid.
     * We traverse the grid multiple times, but each cell is visited and processed a constant number of times.
     *
     * Space Complexity: O(M * N) in the worst case for DFS due to the recursion stack, or O(min(M, N)) in the
     * worst case for BFS if the border has many 'O's connected together, as the queue might contain those cells.
     *
     * Optimal Solution: The provided approach using DFS or BFS from the border 'O's is an optimal and standard way to solve this problem.
     */
    
     class Solution {
         public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#'; 
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}