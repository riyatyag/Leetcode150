// Problem Statement:
// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

// Approach: Using Two Pointers (Dummy Nodes)
// We can maintain two separate linked lists: one for nodes less than x and another for nodes greater than or equal to x.
// We iterate through the original linked list and append each node to the appropriate list based on its value.
// Finally, we concatenate the two lists.

// Step 1: Create two dummy nodes, 'lessHead' and 'greaterHead', to serve as the heads of the two partitioned lists.
// Step 2: Initialize two pointers, 'lessTail' pointing to 'lessHead' and 'greaterTail' pointing to 'greaterHead'. These pointers will track the tails of the respective lists.
// Step 3: Iterate through the original linked list starting from the 'head'.
// Step 4: For each node 'current' in the original list:
//    a. If 'current.val' is less than 'x', append 'current' to the 'less' list by setting 'lessTail.next = current' and moving 'lessTail' to 'current'.
//    b. If 'current.val' is greater than or equal to 'x', append 'current' to the 'greater' list by setting 'greaterTail.next = current' and moving 'greaterTail' to 'current'.
//    c. Move 'current' to the next node in the original list.
// Step 5: After iterating through the entire original list, the 'less' list contains all nodes less than 'x' in their original relative order, and the 'greater' list contains all nodes greater than or equal to 'x' in their original relative order.
// Step 6: Terminate the 'greater' list by setting 'greaterTail.next = null'. This prevents any potential cycles or unintended connections.
// Step 7: Concatenate the two lists by setting the 'next' pointer of the tail of the 'less' list ('lessTail.next') to the head of the 'greater' list (skipping the dummy node 'greaterHead', so 'greaterHead.next').
// Step 8: The head of the partitioned list is the node after the dummy node 'lessHead' ('lessHead.next'). Return this node.

// Optimal Solution:
// This approach iterates through the linked list once, performing constant time operations for each node. It also maintains the original relative order of nodes within each partition.

// Time Complexity: O(n), where n is the number of nodes in the linked list, as we traverse the list once.
// Space Complexity: O(1), as we are only using a constant number of extra pointers and dummy nodes, regardless of the input list size.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//  Code
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode lessTail = lessHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;
        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                lessTail.next = current;
                lessTail = current;
            } else {
                greaterTail.next = current;
                greaterTail = current;
            }
            current = current.next;
        }

        greaterTail.next = null;
        lessTail.next = greaterHead.next;

        return lessHead.next;
    }
}