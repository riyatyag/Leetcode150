/**
 * Problem Statement:
 * Given the head of a singly linked list, determine if the linked list has a
 * cycle in it. A cycle exists if there is some node in the list that can be
 * reached again by continuously following the `next` pointer.
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * `pos` is -1 or a valid index in the linked-list (although `pos` is not
 * passed as a parameter to the function).
 *
 * Follow up: Can you solve it using O(1) (i.e., constant) memory?
 *
 * Approach:
 * The most efficient way to detect a cycle in a linked list with O(1) memory
 * is using Floyd's Cycle-Finding Algorithm, also known as the "tortoise and
 * hare" algorithm. This approach involves using two pointers that traverse the
 * linked list at different speeds.
 *
 * Optimal Solution:
 * 1. Initialize two pointers, `slow` and `fast`, both starting at the `head`
 * of the linked list. However, a slight optimization is to start `slow` at
 * the `head` and `fast` at `head.next`. This handles the case of a single-node
 * list or an empty list more cleanly in the initial checks.
 * 2. Iterate through the linked list with both pointers. The `slow` pointer
 * moves one node at a time, while the `fast` pointer moves two nodes at a
 * time.
 * 3. In each step, check if the `slow` and `fast` pointers are pointing to
 * the same node. If they are, it means there is a cycle in the linked list,
 * and we can return `true`.
 * 4. Continue this process until the `fast` pointer reaches the end of the
 * list (i.e., `fast` becomes `null`) or the node after the `fast` pointer
 * is `null` (i.e., `fast.next` becomes `null`). If the `fast` pointer reaches
 * the end without meeting the `slow` pointer, it means there is no cycle in
 * the list, and we can return `false`.
 * 5. Handle the edge cases where the list is empty (`head == null`) or has
 * only one node (`head.next == null`). In these cases, a cycle is impossible,
 * so we should return `false` directly at the beginning.
 *
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * In the worst case (a cycle exists), the `fast` pointer might traverse the
 * entire list (or a significant portion of it) before meeting the `slow`
 * pointer. In the case of no cycle, the `fast` pointer will traverse the entire
 * list once.
 *
 * Space Complexity: O(1), as we are only using two pointers (`slow` and `fast`),
 * which require constant extra space. This satisfies the follow-up requirement
 * of using O(1) memory.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}





