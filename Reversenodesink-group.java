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
 * The provided solution implements the two-pointer approach to solve this
 * problem in a single pass. It utilizes a dummy node to handle edge cases
 * where the head of the list needs to be removed. Two pointers, `fast` and
 * `slow`, are initialized to the dummy node. The `fast` pointer is moved `n`
 * steps ahead of the `slow` pointer. Then, both pointers are moved
 * simultaneously until the `fast` pointer reaches the end of the list. At
 * this point, the `slow` pointer will be positioned at the node just before
 * the nth node from the end, allowing for its removal by adjusting the
 * `next` pointer.
 *
 * Optimal Solution Breakdown:
 * 1. Dummy Node: A `dummy` node with a value of 0 is created. Its `next`
 * pointer is set to the original `head` of the linked list. This simplifies
 * the removal of the first node if necessary.
 * 2. Initialize Pointers: Two `ListNode` pointers, `fast` and `slow`, are
 * initialized to the `dummy` node.
 * 3. Advance `fast` Pointer: The `fast` pointer is moved `n` steps forward
 * in the linked list. After this loop, the `fast` pointer will be `n` nodes
 * ahead of the `slow` pointer.
 * 4. Move Both Pointers: The `while` loop continues as long as `fast.next`
 * is not `null`. In each iteration, both `slow` and `fast` pointers are
 * moved one step forward. When `fast` reaches the last node, `slow` will be
 * at the node preceding the nth node from the end.
 * 5. Remove the Nth Node: The line `slow.next = slow.next.next;` effectively
 * removes the nth node from the end. The `next` pointer of `slow` is updated
 * to point to the node after the one to be removed, thus bypassing it.
 * 6. Return Head: Finally, `dummy.next` is returned. Since `dummy` was
 * placed before the original head, `dummy.next` will now point to the head
 * of the modified linked list.
 *
 * Time Complexity: O(L), where L is the number of nodes in the linked list.
 * The `fast` pointer traverses the list once, and the `slow` pointer also
 * traverses a portion of the list in the same pass.
 *
 * Space Complexity: O(1), as the solution uses a constant amount of extra
 * space for the dummy node and the two pointers, regardless of the size of
 * the input list.
 */

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




