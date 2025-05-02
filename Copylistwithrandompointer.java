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
 * We can solve this problem using a hash map to keep track of the mapping
 * between the original nodes and their corresponding copied nodes. The process
 * involves two main passes through the original linked list.
 *
 * Optimal Solution:
 * 1. **First Pass: Create Copied Nodes and Store Mapping:**
 * - Iterate through the original linked list.
 * - For each node in the original list, create a new node with the same
 * value.
 * - Store a mapping between the original node and its newly created copy
 * in a hash map. The original node will be the key, and the copied node
 * will be the value.
 *
 * 2. **Second Pass: Set Next and Random Pointers of Copied Nodes:**
 * - Iterate through the original linked list again.
 * - For each original node:
 * - Retrieve its corresponding copied node from the hash map.
 * - Set the `next` pointer of the copied node to the copied version of
 * the original node's `next` pointer (if it exists). We can get the
 * copied version by looking up the original `next` node in the hash map.
 * - Set the `random` pointer of the copied node to the copied version of
 * the original node's `random` pointer (if it exists). Again, we use
 * the hash map to find the copied counterpart.
 *
 * 3. **Return Head of Copied List:**
 * - After the second pass, the hash map will contain all the original
 * nodes mapped to their deep-copied counterparts with their `next` and
 * `random` pointers correctly set.
 * - Return the copied node that corresponds to the original head node (which
 * we can retrieve from the hash map using the original head as the key).
 *
 * Time Complexity: O(N), where N is the number of nodes in the linked list.
 * We iterate through the list twice. The hash map operations (insertion and
 * lookup) take O(1) on average.
 *
 * Space Complexity: O(N), as we use a hash map to store the mapping between
 * the original nodes and their copies. In the worst case, we will have N
 * entries in the hash map.
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