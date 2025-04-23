/*
Problem Statement:
- You are given a string `s` representing a Roman numeral.
- Your task is to convert the Roman numeral to an integer.

Approach:
- We use a HashMap to store the Roman numerals and their corresponding integer values.
- The Roman numeral system uses subtraction in some cases (e.g., IV for 4, IX for 9).
- Iterate through the string `s`:
  - If the value of the current numeral is less than the value of the next numeral, subtract it from the result.
  - Otherwise, add it to the result.

Optimal Solution:
- The time complexity is O(n), where n is the length of the input string `s`.
- The space complexity is O(1), since the size of the map is constant (7 entries for the 7 Roman symbols).

Pseudo Code:
1. Create a HashMap to store the values of Roman numerals.
2. Initialize an integer variable `result` to store the final integer value.
3. Loop through the string `s`:
   - If the value of the current numeral is less than the next one, subtract it from the result.
   - Otherwise, add its value to the result.
4. Return the final value of `result`.

Example Walkthrough:
- Input: "III"
  - 'I' = 1, 'I' = 1, 'I' = 1.
  - Sum: 1 + 1 + 1 = 3.
- Input: "LVIII"
  - 'L' = 50, 'V' = 5, 'I' = 1, 'I' = 1, 'I' = 1.
  - Sum: 50 + 5 + 1 + 1 + 1 = 58.
- Input: "MCMXCIV"
  - 'M' = 1000, 'CM' = 900, 'XC' = 90, 'IV' = 4.
  - Sum: 1000 + 900 + 90 + 4 = 1994.

*/

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }
        
        return result;
    }
}
