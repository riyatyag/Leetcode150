//  Problem Statement:
// Given an integer num between 1 and 3999, convert it to its Roman numeral representation based on Roman numeral rules.

//  Approach:
// Roman numerals have fixed symbols for values like 1, 4, 5, 9, 10, 40, etc.

// We use a greedy approach:

// Always subtract the largest possible Roman value from num.

// Append the corresponding Roman symbol.

// Repeat until num becomes 0.

// This works because Roman numeral construction always favors the largest possible numeral that fits into the number.

//  Pseudo Code:

// Create arrays for values and corresponding symbols in descending order.
// Initialize empty string for result.

// Loop over the values:
//     While current value <= num:
//         Append symbol to result.
//         Subtract value from num.

// Return result.

class Solution {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40, 10,   9,   5,   4,  1};
        String[] symbols = {"M", "CM","D", "CD","C", "XC","L", "XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}
