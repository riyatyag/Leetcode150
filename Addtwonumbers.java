/**
 * Problem Statement:
 * Given the head of a linked list where each node contains an additional
 * random pointer that can point to any node in the list or null, construct a
 * deep copy of this list. The deep copy should consist of new nodes with the
 * same values, and their next and random pointers should also point to the
 * corresponding new nodes in the copied list, maintaining the same structure
 * as the original list. None of the pointers in the new list should point to
 * nodes in the original list.
 *
 * Constraints:
 * 0 <= n <= 1000 (where n is the length of the linked list)
 * -104 <= Node.val <= 104
 * Node.random is null or points to some node in the linked list.
 *
 * Approach:
 * The provided solution uses a hash map to create a deep copy of the linked
 * list with random pointers. This approach involves three main steps:
 * 1. Create a mapping between each original node and its corresponding new
 * node.
 * 2. Iterate through the original list again to set the `next` and `random`
 * pointers of the new nodes using the mapping created in the first step.
 * 3. Return the head of the newly created linked list.
 *
 * Optimal Solution Breakdown:
 * 1. Create Node Copies and Mapping:
 * - A `HashMap` is used to store the relationship between the original
 * nodes and their deep copies.
 * - The code iterates through the original linked list. For each node, a
 * new node with the same value is created, and a mapping from the
 * original node to the new node is stored in the hash map.
 *
 * 2. Set Next and Random Pointers:
 * - The code iterates through the original linked list a second time.
 * - For each original node, it retrieves its corresponding new node from
 * the hash map.
 * - The `next` pointer of the new node is set to the new node that
 * corresponds to the original node's `next` pointer (obtained from the
 * hash map).
 * - Similarly, the `random` pointer of the new node is set to the new node
 * that corresponds to the original node's `random` pointer (also
 * obtained from the hash map).
 *
 * 3. Return Head of Copied List:
 * - After setting all the `next` and `random` pointers of the new nodes,
 * the head of the copied linked list is the new node that corresponds
 * to the original head node (retrieved from the hash map). This head of
 * the copied list is returned.
 *
 * Time Complexity: O(N), where N is the number of nodes in the original list.
 * We traverse the list twice. The hash map operations (insertion and retrieval)
 * take O(1) on average.
 *
 * Space Complexity: O(N), as we use a hash map to store the mapping between
 * each of the N original nodes and their corresponding N new nodes.
 */

 /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            Node copyNode = map.get(current);
            copyNode.next = map.get(current.next);
            copyNode.random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}