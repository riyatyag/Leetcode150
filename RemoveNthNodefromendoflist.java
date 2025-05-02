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
 * We can solve this problem in one pass using two pointers, often referred to
 * as the "fast" and "slow" pointer approach. The idea is to position the "fast"
 * pointer n nodes ahead of the "slow" pointer. Then, we move both pointers
 * simultaneously until the "fast" pointer reaches the end of the list. At this
 * point, the "slow" pointer will be pointing to the node just before the nth
 * node from the end. By adjusting the "next" pointer of the "slow" node, we can
 * effectively remove the nth node from the end.
 *
 * To handle the edge case where the node to be removed is the head of the
 * list (i.e., n is equal to the length of the list), we can use a dummy node
 * at the beginning of the list. This simplifies the logic for updating the
 * head.
 *
 * Optimal Solution:
 * 1. Create a dummy node and set its `next` pointer to the original `head` of
 * the linked list.
 * 2. Initialize two pointers, `fast` and `slow`, both pointing to the dummy
 * node.
 * 3. Move the `fast` pointer `n` steps forward in the linked list.
 * 4. Now, move both the `fast` and `slow` pointers one step at a time until
 * the `fast` pointer reaches the end of the list (i.e., `fast.next` becomes
 * `null`).
 * 5. When the `fast` pointer reaches the end, the `slow` pointer will be
 * positioned at the node immediately preceding the nth node from the end.
 * 6. To remove the nth node from the end, update the `next` pointer of the
 * `slow` node to skip the next node: `slow.next = slow.next.next`.
 * 7. Finally, return the `next` of the dummy node, which will be the head of
 * the modified linked list.
 *
 * Time Complexity: O(L), where L is the number of nodes in the linked list.
 * We traverse the list at most once with the `fast` pointer and at most once
 * with the `slow` pointer.
 *
 * Space Complexity: O(1), as we are only using a constant amount of extra
 * space for the dummy node and the two pointers.
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
