//  Problem Statement:
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// 1. Each row must contain the digits 1-9 without repetition.
// 2. Each column must contain the digits 1-9 without repetition.
// 3. Each of the nine 3 x 3 sub-boxes must contain the digits 1-9 without repetition.
// Note: The board may be partially filled and not necessarily solvable. Only the filled cells need to be validated.

//  Example 1:
// Input: board = 
// [["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]]
// Output: true

//  Example 2:
// Input: board = 
// [["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: There are two 8's in the top left 3x3 sub-box, so the board is invalid.

//  Approach (Validation of Rows, Columns, and Sub-grids):
// 1. Use a set to track the values seen in rows, columns, and sub-boxes.
// 2. For each filled cell, check if the value already exists in the corresponding row, column, or 3x3 sub-box.
// 3. The 3x3 sub-box can be identified by using integer division (i / 3, j / 3).
// 4. If a duplicate is found, return false, otherwise continue checking.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                
                if (num == '.') continue;

                String rowKey = "row" + i + num;
                String colKey = "col" + j + num;
                String boxKey = "box" + (i / 3) + (j / 3) + num;

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }
        
        return true;
    }
}
