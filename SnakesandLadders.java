    /**
     * Problem Statement: Find the least number of dice rolls required to reach the square n^2 on a Snakes and Ladders board.
     * The board is labeled in Boustrophedon style, and moves are determined by a 6-sided die roll, followed by mandatory moves to snakes or ladders.
     *
     * Approach:
     * Use Breadth-First Search (BFS). The starting square is 1, and the target is n^2. Each possible move from a square represents an edge. We want to find the shortest path (minimum number of rolls).
     * Convert the 1D square number to 2D board coordinates (row and column) based on the Boustrophedon style.
     * Use a queue to perform BFS, storing the current square number and the number of moves made so far.
     * Maintain a visited array to avoid cycles and redundant processing of squares.
     * For each square in the queue, simulate all possible dice rolls (1 to 6).
     * For each possible next square, determine the final destination after considering snakes or ladders.
     * If the destination is n^2, return the current move count + 1.
     * If the destination has not been visited, mark it as visited and add it to the queue with an incremented move count.
     * If the queue becomes empty and n^2 is not reached, return -1.
     *
     * Time Complexity: O(N^2), where N is the size of the board. In the worst case, we might visit each square once. For each square, we iterate through at most 6 possible dice rolls.
     *
     * Space Complexity: O(N^2), to store the visited array and the queue in the worst case.
     *
     * Optimal Solution: BFS is the optimal approach for finding the shortest path in this unweighted graph problem.
     */
    class Solution {
          public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0];
            int moves = curr[1];

            if (square == n * n) {
                return moves;
            }

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                if (nextSquare > n * n) {
                    continue;
                }

                int[] rc = getRowCol(nextSquare, n);
                int r = rc[0];
                int c = rc[1];

                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }

                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getRowCol(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;
        if ((n - 1 - row) % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}