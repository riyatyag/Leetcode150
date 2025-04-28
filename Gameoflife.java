//  Problem Statement:
// The Game of Life is a cellular automaton devised by John Horton Conway. 
// It simulates the life cycle of cells on a 2D grid, where each cell can either be alive (1) or dead (0).
// The state of the grid changes simultaneously based on the following rules:
// 1. Any live cell with fewer than two live neighbors dies (under-population).
// 2. Any live cell with two or three live neighbors stays alive (normal).
// 3. Any live cell with more than three live neighbors dies (over-population).
// 4. Any dead cell with exactly three live neighbors becomes alive (reproduction).

// Given a grid representing the current state of the board, update the board to reflect its next state.


//  Example 1:
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

//  Example 2:
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]

//  Approach (In-place update with bit manipulation):
// 1. We can modify the board in-place by using the following approach:
// 2. Represent the current state and next state using different bit values. 
//    For example, if the current state is alive (1), mark it as 3 (10 in binary), 
//    and if it is dead (0), mark it as 2 (10 in binary) to store the previous and next state at the same time.
// 3. Once all the cells are updated, perform bit manipulation to extract the next state (right shift).

//  Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.
//  Space Complexity: O(1), since we modify the board in-place.

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},         {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
                        liveNeighbors++;
                    }
                }

                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;  
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 3;  
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; 
            }
        }
    }
}
