    /**
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     * return the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Approach:
     * Iterate through each cell of the grid. If a cell represents land ('1') and has not been visited yet,
     * increment the island count and perform a Depth First Search (DFS) or Breadth First Search (BFS)
     * starting from this cell to mark all connected land cells as visited.
     *
     * Time Complexity: O(M * N), where M is the number of rows and N is the number of columns in the grid.
     * This is because each cell in the grid will be visited at most once during the DFS/BFS traversal.
     *
     * Space Complexity: O(M * N) in the worst case for DFS due to the recursion stack, or O(min(M, N)) in the
     * worst case for BFS if the grid is filled with land, as the queue might contain all the land cells.
     *
     * Optimal Solution: The provided DFS approach is already optimal in terms of time complexity.
     */
    class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; 
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
