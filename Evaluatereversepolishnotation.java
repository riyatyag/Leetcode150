// Problem Statement:
// Evaluate an arithmetic expression given in Reverse Polish Notation (RPN).
// The input is an array of strings, where each string is either an operator (+, -, *, /) or an integer.
// The division between two integers should truncate toward zero.
// The input RPN expression is guaranteed to be valid.

// Approach: Using a Stack
// The core idea of evaluating RPN is to use a stack.
// We iterate through the tokens. If a token is an operand (number), we push it onto the stack.
// If a token is an operator, we pop the last two operands from the stack, perform the operation, and push the result back onto the stack.
// After processing all the tokens, the final result will be the only element remaining on the stack.

// Step 1: Initialize an empty stack to store operands.
// Step 2: Iterate through each token in the input array.
// Step 3: If the token is an operator (+, -, *, /):
//    a. Pop the top two elements from the stack. Note that the order matters for subtraction and division; the first popped element is the second operand, and the second popped element is the first operand.
//    b. Perform the corresponding arithmetic operation.
//    c. Push the result back onto the stack.
// Step 4: If the token is a number, parse it as an integer and push it onto the stack.
// Step 5: After processing all tokens, the final result of the expression will be the only element left in the stack. Pop and return this value.

// Optimal Solution:
// The stack-based approach is the standard and most efficient way to evaluate RPN expressions.

// Time Complexity: O(n), where n is the number of tokens in the input array, as we process each token once.
// Space Complexity: O(n) in the worst case, where the expression consists only of numbers, and all of them will be pushed onto the stack before any operations are performed. However, in a balanced expression, the space complexity would be lower.


import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}