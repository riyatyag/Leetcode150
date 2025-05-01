// Problem Statement:
// Given an absolute path for a Unix-style file system, simplify it to the canonical path.
// Rules for simplification:
// - Single period '.' represents the current directory (ignore).
// - Double period '..' represents the parent directory (go up one level).
// - Multiple consecutive slashes '//' are treated as a single slash '/'.
// - The canonical path must start with a single '/'.
// - Directories within the path are separated by exactly one '/'.
// - The path must not end with a '/', unless it's the root directory "/".
// - Any sequence of periods that does not match '.' or '..' is treated as a valid directory/file name.

// Approach: Using a Stack
// We can split the input path by the delimiter '/' to get individual components (directory/file names, '.', '..', empty strings due to consecutive slashes).
// We then iterate through these components and use a stack to build the simplified path.

// Step 1: Split the input 'path' string by the '/' delimiter. This will give us an array of strings.

// Step 2: Initialize an empty stack to store the valid directory/file names in the simplified path.

// Step 3: Iterate through each 'part' obtained from splitting the path:
//    a. If the 'part' is empty (due to consecutive slashes) or equal to ".", ignore it as it represents the current directory.
//    b. If the 'part' is equal to "..", it represents going up to the parent directory. If the stack is not empty, pop the top element (representing the current directory/file) from the stack.
//    c. If the 'part' is any other valid directory/file name, push it onto the stack.

// Step 4: After processing all parts, if the stack is empty, it means the simplified path is just the root directory "/", so return "/".

// Step 5: If the stack is not empty, build the simplified path by iterating through the elements in the stack.
//    a. Start with a StringBuilder.
//    b. For each element in the stack, append a "/" followed by the element.
//    c. Finally, convert the StringBuilder to a String and return it.

// Optimal Solution:
// The stack-based approach efficiently handles the rules of path simplification.

// Time Complexity: O(n), where n is the length of the input path, as we iterate through the split parts of the path once.
// Space Complexity: O(n) in the worst case, where the simplified path contains a similar number of directories/files as the original path (e.g., "/a/b/c/..."). The stack can grow up to the number of valid directory/file names.

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append("/");
            result.append(s);
        }
        return result.toString();
    }
}