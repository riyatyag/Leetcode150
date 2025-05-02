//  * Problem Statement:
//  * Given the head of a linked list where each node contains an additional
//  * random pointer that can point to any node in the list or null, construct a
//  * deep copy of this list. The deep copy should consist of new nodes with the
//  * same values, and their next and random pointers should also point to the
//  * corresponding new nodes in the copied list, maintaining the same structure
//  * as the original list. None of the pointers in the new list should point to
//  * nodes in the original list.
//  *
//  * Constraints:
//  * 0 <= n <= 1000 (where n is the length of the linked list)
//  * -104 <= Node.val <= 104
//  * Node.random is null or points to some node in the linked list.
//  *
//  * Approach:
//  * The provided solution utilizes a hash map to efficiently create a deep copy
//  * of the linked list with random pointers. The algorithm proceeds in three
//  * distinct steps: first, it creates copies of all the nodes and stores a
//  * mapping between the original and copied nodes in the hash map. Second, it
//  * iterates through the original list again to set the `next` and `random`
//  * pointers of the copied nodes by looking up their corresponding nodes in
//  * the hash map. Finally, it returns the head of the newly created copied list.
//  *
//  * Optimal Solution Breakdown:
//  * 1. First Pass: Create Node Copies and Mapping:
//  * - A `HashMap` called `map` is initialized to store the mapping between
//  * original `Node` objects and their corresponding deep-copied `Node`
//  * objects.
//  * - The code iterates through the original linked list using a `current`
//  * pointer starting from the `head`.
//  * - For each `current` node encountered, a new `Node` with the same `val`
//  * is created. This new node is the copy of the `current` node.
//  * - The original `current` node and its newly created copy are put into the
//  * `map`, with the original node as the key and the copy as the value.
//  * - The `current` pointer is moved to the next node in the original list.
//  *
//  * 2. Second Pass: Set Next and Random Pointers of Copies:
//  * - The `current` pointer is reset to the `head` of the original list.
//  * - The code iterates through the original list again.
//  * - For each `current` node:
//  * - The corresponding copied node (`copyNode`) is retrieved from the `map`
//  * using the `current` node as the key.
//  * - The `next` pointer of `copyNode` is set to the copied version of the
//  * original `current.next` node. This is done by looking up `current.next`
//  * in the `map`. If `current.next` is `null`, then `copyNode.next` will
//  * also be `null`.
//  * - Similarly, the `random` pointer of `copyNode` is set to the copied
//  * version of the original `current.random` node by looking up
//  * `current.random` in the `map`. If `current.random` is `null`, then
//  * `copyNode.random` will also be `null`.
//  * - The `current` pointer is moved to the next node in the original list.
//  *
//  * 3. Return Head of Copied List:
//  * - After the second pass, all the copied nodes have their `next` and
//  * `random` pointers correctly pointing to other nodes in the copied list.
//  * - The head of the copied list is obtained by looking up the original `head`
//  * node in the `map`. The corresponding value is the deep-copied head.
//  * - This copied head is then returned.
//  *
//  * Time Complexity: O(N), where N is the number of nodes in the original list.
//  * We traverse the list twice. The hash map operations (put and get) take
//  * O(1) on average.
//  *
//  * Space Complexity: O(N), as we use a hash map to store the mapping between
//  * each of the N original nodes and their corresponding N copied nodes.
 
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