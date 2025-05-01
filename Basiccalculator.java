// Problem Statement:
// Implement a basic calculator to evaluate a simple expression string.
// The expression string may contain digits, '+', '-', '(', ')', and space ' '.

// Approach: Using a Stack
// We can iterate through the string and maintain a running result and the current sign.
// When we encounter an opening parenthesis '(', we push the current result and sign onto the stack.
// When we encounter a closing parenthesis ')', we evaluate the expression within the parenthesis and update the result.

// Step 1: Initialize a stack to store intermediate results and signs.
// Step 2: Initialize the result to 0, the current number to 0, and the current sign to 1 (positive).
// Step 3: Iterate through the input string character by character.
// Step 4: If the character is a digit, update the current number.
// Step 5: If the character is '+', add the current number multiplied by the current sign to the result, reset the number to 0, and set the sign to 1.
// Step 6: If the character is '-', add the current number multiplied by the current sign to the result, reset the number to 0, and set the sign to -1.
// Step 7: If the character is '(', push the current result and the current sign onto the stack, reset the result and the sign for the inner expression.
// Step 8: If the character is ')', add the current number multiplied by the current sign to the result, then multiply the result by the sign popped from the stack, and finally add the previous result popped from the stack. Reset the number.
// Step 9: After iterating through the entire string, add the last number multiplied by the sign to the result.
// Step 10: Return the final result.

// Optimal Solution:
// The stack-based approach provides an efficient way to handle nested parentheses and operator precedence (addition and subtraction).

// Time Complexity: O(n), where n is the length of the input string, as we iterate through the string once.
// Space Complexity: O(n) in the worst case due to the stack, which can store results and signs for nested parentheses. For example, in an expression like "((((...))))," the depth of the stack can be proportional to the length of the string.


import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result += sign * number;
        return result;
    }
}