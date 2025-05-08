/**
     * Problem Statement:
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     *
     * Approach:
     * We can use a backtracking approach to solve this problem. We will try to place queens row by row. For each row, we will iterate through all the columns and try to place a queen in that column if it is safe (i.e., no other queen attacks it).
     * To check if a position is safe, we need to ensure that no other queen is in the same column or on the same diagonal. We can use sets to keep track of the columns and diagonals that are already occupied by queens.
     * We will use three sets:
     * 1. `cols`: to store the columns where a queen has been placed.
     * 2. `diag1`: to store the diagonals where a queen has been placed. A queen at (row, col) lies on the diagonal with equation `row - col = constant`. We can use the value `row - col` as the identifier for this diagonal.
     * 3. `diag2`: to store the anti-diagonals where a queen has been placed. A queen at (row, col) lies on the anti-diagonal with equation `row + col = constant`. We can use the value `row + col` as the identifier for this anti-diagonal.
     * The backtracking function will take the current row number, the size of the board n, and the three sets as parameters.
     * The base case for the recursion is when the current row is equal to n, which means we have successfully placed n queens, so we return 1 (one solution found).
     * In the recursive step, we iterate through all the columns in the current row. For each column, we check if it is safe to place a queen there (i.e., the column and both diagonals are not occupied). If it is safe, we place the queen (by adding the column and diagonal identifiers to the sets) and make a recursive call for the next row. After the recursive call returns, we backtrack by removing the column and diagonal identifiers from the sets, so that we can explore other possibilities.
     * The total number of solutions will be the sum of the solutions returned by the recursive calls.
     *
     * Time Complexity: O(N!), where N is the size of the board. In the worst case, we might explore all possible placements of queens.
     *
     * Space Complexity: O(N), due to the space used by the sets to store the occupied columns and diagonals, and the recursion stack which can go up to N levels.
     *
     * Optimal Solution:
     * The backtracking approach with pruning using sets to track occupied columns and diagonals is an efficient way to solve this problem. There aren't significantly faster algorithms for finding the number of distinct solutions to the N-Queens problem for larger values of N.
     */
    import java.util.HashSet;
    import java.util.Set;

class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            return 1;
        }

        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col;
            int d2 = row + col;
            if (!cols.contains(col) && !diag1.contains(d1) && !diag2.contains(d2)) {
                cols.add(col);
                diag1.add(d1);
                diag2.add(d2);
                solutions += backtrack(row + 1, n, cols, diag1, diag2);
                cols.remove(col);
                diag1.remove(d1);
                diag2.remove(d2);
            }
        }
        return solutions;
    }
}