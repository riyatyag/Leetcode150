/**
 * Problem Statement: Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory?
 *
 * Approach: Merge Sort.
 * 1. Find the middle of the linked list using the slow and fast pointer approach.
 * 2. Recursively sort the left and right halves of the list.
 * 3. Merge the sorted left and right halves.
 *
 * Time Complexity: O(n log n), where n is the number of nodes in the linked list.
 * - The list is divided into halves log n times.
 * - Merging two sorted lists of size n/2 takes O(n) time.
 *
 * Space Complexity: O(log n) due to the recursive calls. To achieve O(1) space complexity, an iterative merge sort approach can be used.
 *
 * Optimal Solution: Merge Sort achieves O(n log n) time complexity, which is optimal for comparison-based sorting algorithms. An iterative implementation can achieve O(1) space complexity.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummyHead.next;
    }
}