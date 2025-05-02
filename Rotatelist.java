// Problem Statement:
// Given the head of a linked list, rotate the list to the right by k places.

// Approach: Find Length, Connect Tail to Head, Break at New Tail
// The idea is to first find the length of the linked list.
// Then, we can determine the effective number of rotations by taking k modulo the length.
// If the effective k is 0, no rotation is needed.
// Otherwise, we connect the tail of the linked list to its head, forming a cycle.
// Then, we traverse the cycle to find the new head and the new tail of the rotated list.
// The new head will be k nodes away from the original tail (moving backwards).
// The node before the new head will become the new tail, and its 'next' pointer should be set to null to break the cycle.

// Step 1: Handle edge cases where the list is empty or k is 0. In these cases, return the original head.

// Step 2: Traverse the linked list to find its length. While traversing, also keep track of the tail node (the last node).

// Step 3: Calculate the effective number of rotations by taking k modulo the length of the list (k % length). This handles cases where k is larger than the list length.

// Step 4: If the effective k is 0, it means no rotation is needed, so return the original head.

// Step 5: Connect the tail of the linked list to its head. This creates a circular linked list.

// Step 6: Determine the position of the new head. The new head will be 'k' nodes away from the original tail, moving backwards. This is equivalent to moving 'length - k' nodes from the original head.

// Step 7: Traverse the circular linked list starting from the original head, 'length - k - 1' times. The node at this position will be the new tail of the rotated list.

// Step 8: The next node after the new tail will be the new head of the rotated list. Store this new head.

// Step 9: Break the cycle by setting the 'next' pointer of the new tail to null.

// Step 10: Return the new head of the rotated linked list.

// Optimal Solution:
// This approach efficiently finds the new head and tail in a single pass (after the initial length calculation).

// Time Complexity: O(n), where n is the number of nodes in the linked list. We traverse the list once to find the length and then at most once more to find the new head and tail.
// Space Complexity: O(1), as we are using a constant number of extra pointers.


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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        current.next = head;
        ListNode temp = head;
        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}