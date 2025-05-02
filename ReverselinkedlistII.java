/**
 * Problem Statement:
 * Given the head of a linked list, remove the nth node from the end of the
 * list and return its head.
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Approach:
 * The provided solution effectively uses the two-pointer technique to find and
 * remove the nth node from the end of the linked list in a single traversal.
 * A dummy node is employed to simplify the handling of the head node removal.
 * The `fast` pointer is initially advanced `n` steps ahead of the `slow`
 * pointer. Subsequently, both pointers traverse the list at the same pace.
 * When the `fast` pointer reaches the end of the list, the `slow` pointer will
 * be positioned just before the nth node from the end, allowing for its
 * removal by adjusting the `next` pointer of the `slow` node.
 *
 * Optimal Solution Breakdown:
 * 1. Dummy Node: A `dummy` node with an arbitrary value (here, 0) is created.
 * Its `next` pointer is set to the original `head` of the linked list. This
 * acts as a placeholder and simplifies operations, especially when the head
 * node needs to be removed.
 * 2. Initialize Pointers: Two `ListNode` pointers, `fast` and `slow`, are
 * initialized to point to the `dummy` node.
 * 3. Advance `fast` Pointer: The `fast` pointer is moved `n` steps forward in
 * the linked list using a `for` loop. After this loop, the `fast` pointer is
 * `n` nodes ahead of the `slow` pointer.
 * 4. Move Both Pointers: A `while` loop continues as long as `fast.next` is
 * not `null`. In each iteration, both the `slow` and `fast` pointers are
 * moved one step forward. This maintains a constant `n` distance between
 * them. When `fast` reaches the last node of the list, `slow` will be pointing
 * to the node immediately preceding the nth node from the end.
 * 5. Remove the Nth Node: The line `slow.next = slow.next.next;` performs the
 * removal. The `next` pointer of the `slow` node is updated to skip the next
 * node, which is the nth node from the end.
 * 6. Return Head: Finally, `dummy.next` is returned. Since the `dummy` node
 * was placed before the original head, `dummy.next` now points to the head
 * of the modified linked list (which might be the original head or the
 * second node if the original head was removed).
 *
 * Time Complexity: O(L), where L is the number of nodes in the linked list.
 * The `fast` pointer traverses the list at most once, and the `slow` pointer
 * also traverses a portion of the list in the same pass.
 *
 * Space Complexity: O(1), as the solution uses a constant amount of extra
 * space for the dummy node and the two pointers, regardless of the size of
 * the input linked list.
 */


// Code

 
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
     public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode fast = dummy;
         ListNode slow = dummy;
 
         for (int i = 0; i < n; i++) {
             fast = fast.next;
         }
 
         while (fast.next != null) {
             slow = slow.next;
             fast = fast.next;
         }
 
         slow.next = slow.next.next;
 
         return dummy.next;
     }
 }
 
 