//  Problem Statement:
// Convert a given string `s` into a zigzag pattern based on the number of rows `numRows`,
// then read the pattern row by row and return the resulting string.

//  Example Explanation:
// For s = "PAYPALISHIRING", numRows = 3:
// The zigzag pattern is:
// P   A   H   N  
// A P L S I I G  
// Y   I   R  
// Reading line by line: "PAHNAPLSIIGYIR"

//  Approach:
// 1. If numRows == 1 or string length <= numRows, return original string (no zigzag needed).
// 2. Create an array of StringBuilder, one for each row.
// 3. Traverse the string and simulate the zigzag by moving down and then up diagonally.
// 4. Append each character to the correct row's StringBuilder.
// 5. Join all rows to get the final result.

//  Pseudo Code:
// - If numRows is 1 or s.length() <= numRows → return s
// - Create an array of StringBuilder for numRows
// - For each character in s:
//     - Append it to the current row
//     - Change direction when top or bottom is reached
// - Join all StringBuilders and return

//  Time Complexity: O(n) → where n is length of the string
// Space Complexity: O(n) → for storing result in StringBuilders

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) result.append(row);
        return result.toString();
    }
}
