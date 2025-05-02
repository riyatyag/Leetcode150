/**
 * Problem Statement:
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. Return the
 * linked list sorted as well.
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 * Approach:
 * We can iterate through the sorted linked list and identify consecutive nodes
 * with the same value. When we find such a sequence of duplicates, we need to
 * skip all of them. We need to keep track of the previous node that was not a
 * duplicate to correctly link the remaining distinct nodes.
 *
 * To handle the case where the head of the original list might be part of a
 * sequence of duplicates, it's useful to introduce a dummy node at the
 * beginning of the list. This dummy node simplifies the logic for updating the
 * head of the resulting list.
 *
 * We will use two pointers, `prev` and `curr`. `prev` will point to the node
 * just before the current sequence of nodes we are examining, and `curr` will
 * point to the current node.
 *
 * Optimal Solution:
 * 1. Initialize a dummy node and set its `next` pointer to the original `head`
 * of the linked list. This dummy node will serve as a stable starting point
 * and handle cases where the initial nodes are duplicates.
 * 2. Initialize two pointers: `prev` to the dummy node and `curr` to the
 * original `head`.
 * 3. Iterate through the linked list using the `curr` pointer.
 * 4. Inside the loop, check if the current node (`curr`) has a next node and if
 * their values are equal (`curr.val == curr.next.val`).
 * 5. If duplicates are found:
 * * Enter an inner loop that continues as long as there is a next node and
 * its value is the same as the current node's value.
 * * Inside the inner loop, advance the `curr` pointer to skip all the
 * duplicate nodes.
 * * After the inner loop, `curr` will be pointing to the last node in the
 * sequence of duplicates (or a unique node if duplicates were at the end).
 * We need to bypass all these duplicate nodes by setting `prev.next` to
 * `curr.next`.
 * 6. If no duplicates are found (i.e., `curr.next` is `null` or
 * `curr.val != curr.next.val`):
 * * Move the `prev` pointer to the current node (`prev = curr`). This is
 * because the current node is a distinct node that should be part of the
 * result.
 * 7. After checking the current node, move the `curr` pointer to its next node
 * (`curr = curr.next`).
 * 8. Once the entire list is traversed, the `next` pointer of the dummy node
 * will point to the head of the modified linked list containing only
 * distinct elements. Return `dummy.next`.
 *
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * We traverse the list at most once.
 *
 * Space Complexity: O(1), as we are only using a constant amount of extra
 * space for the dummy node and the pointers.
 */

 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}

