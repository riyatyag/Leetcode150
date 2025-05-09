/**
 * Problem Statement: You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Approach:
 * 1. Create a min-heap to store the head nodes of all the non-empty linked lists.
 * 2. Initialize the merged linked list with a dummy head node.
 * 3. Iterate while the min-heap is not empty:
 * a. Extract the node with the minimum value from the min-heap.
 * b. Append this node to the tail of the merged linked list.
 * c. If the extracted node has a next node, add it to the min-heap.
 * 4. Return the next node of the dummy head, which is the head of the merged sorted linked list.
 *
 * Time Complexity: O(N log k), where N is the total number of nodes in all the linked lists, and k is the number of linked lists.
 * - Inserting each of the N nodes into the min-heap takes O(log k) time.
 * - Extracting each of the N nodes from the min-heap takes O(log k) time.
 *
 * Space Complexity: O(k), where k is the number of linked lists, for storing the min-heap. In the worst case, the heap will contain one node from each list.
 *
 * Optimal Solution: Using a min-heap is an efficient way to solve this problem.
 */
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummyHead.next;
    }
}