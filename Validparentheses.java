// Problem Statement:
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// 3. Every close bracket has a corresponding open bracket of the same type.

// Approach: Using a Stack
// The problem requires us to check for balanced and correctly nested parentheses. A stack is a suitable data structure for this.
// We iterate through the string. When we encounter an opening bracket, we push its corresponding closing bracket onto the stack.
// When we encounter a closing bracket, we check if the stack is empty or if the top of the stack is not equal to the current closing bracket.
// If either of these conditions is true, the string is invalid.
// After iterating through the entire string, if the stack is empty, it means all opening brackets have been correctly closed, and the string is valid.

// Step 1: Initialize an empty stack to store the expected closing brackets.
// Step 2: Iterate through each character 'c' in the input string 's'.
// Step 3: If 'c' is an opening bracket ('(', '{', or '['), push its corresponding closing bracket (')', '}', or ']') onto the stack.
// Step 4: If 'c' is a closing bracket (')', '}', or ']'):
//    a. Check if the stack is empty. If it is, it means there's no corresponding open bracket, so the string is invalid. Return false.
//    b. Pop the top element from the stack. This is the expected closing bracket for the most recently encountered open bracket.
//    c. Compare the popped element with the current closing bracket 'c'. If they are not equal, it means the brackets are not of the same type or are not closed in the correct order, so the string is invalid. Return false.
// Step 5: After iterating through all characters in the string, check if the stack is empty.
//    a. If the stack is empty, it means all open brackets have been correctly closed, so the string is valid. Return true.
//    b. If the stack is not empty, it means there are open brackets that have not been closed, so the string is invalid. Return false.

// Optimal Solution:
// The stack-based approach provides an efficient way to validate the parentheses in O(n) time complexity, where n is the length of the string. The space complexity is also O(n) in the worst case, where the string contains only opening brackets, and all of them will be pushed onto the stack.

// Time Complexity: O(n), where n is the length of the input string, as we iterate through the string once.
// Space Complexity: O(n) in the worst case, where the stack might store up to n/2 opening brackets.


import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}