// Problem Statement:
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time (O(1)).
// Implement the MinStack class with the following methods:
// MinStack(): Initializes the stack object.
// void push(int val): Pushes the element val onto the stack.
// void pop(): Removes the element on the top of the stack.
// int top(): Gets the top element of the stack.
// int getMin(): Retrieves the minimum element in the stack.

// Approach: Using Two Stacks
// We can use two stacks:
// 1. 'stack': The main stack to store all elements.
// 2. 'minStack': An auxiliary stack to store the minimum elements encountered so far.
// The top of 'minStack' will always hold the current minimum element in 'stack'.

// Step 1: Initialize two empty stacks, 'stack' and 'minStack'.

// Step 2: Implement the 'push' operation:
//    a. Push the given 'val' onto the 'stack'.
//    b. If 'minStack' is empty or 'val' is less than or equal to the top of 'minStack', push 'val' onto 'minStack'.
//       This ensures that 'minStack' always has the minimum element at its top.

// Step 3: Implement the 'pop' operation:
//    a. Pop the top element from 'stack'.
//    b. If the popped element is equal to the top of 'minStack', it means the minimum element is being removed. In this case, also pop the top element from 'minStack'.

// Step 4: Implement the 'top' operation:
//    a. Return the top element of the 'stack'. This is the most recently pushed element.

// Step 5: Implement the 'getMin' operation:
//    a. Return the top element of the 'minStack'. This element is the current minimum value in the 'stack'.

// Optimal Solution:
// Using two stacks allows all the required operations (push, pop, top, getMin) to be performed in O(1) time complexity, as each operation involves only constant-time stack operations. The space complexity is O(n) in the worst case, where n is the number of elements in the stack, as we might store each element in both stacks.

// Time Complexity: O(1) for push, pop, top, and getMin operations.
// Space Complexity: O(n), where n is the number of elements in the stack, due to the storage in both stacks.


import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}