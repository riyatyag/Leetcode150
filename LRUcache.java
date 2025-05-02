// Problem Statement:
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class with the following methods:
// LRUCache(int capacity): Initialize the LRU cache with a positive size capacity.
// int get(int key): Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value): Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Approach: Using a HashMap and a Doubly Linked List
// To achieve O(1) average time complexity for both get and put operations, we need a way to quickly access the cache item and also efficiently track the least recently used item.
// We can use a HashMap to store the key-value pairs for O(1) average time complexity for lookups.
// To track the least recently used item, we can use a doubly linked list. The nodes in the doubly linked list will represent the key-value pairs in the cache. The most recently used item will be at the head of the list, and the least recently used item will be at the tail.

// Step 1: Initialize a HashMap 'cache' to store key-value pairs and their corresponding nodes in the doubly linked list.
// Step 2: Initialize the capacity of the LRU cache.
// Step 3: Create a doubly linked list with a 'head' and a 'tail' sentinel node. These sentinel nodes simplify the logic for adding and removing nodes.

// Step 4: Implement the 'get(key)' operation:
//    a. Check if the 'key' exists in the 'cache' HashMap.
//    b. If the key exists, retrieve the corresponding doubly linked list node.
//    c. Move this node to the head of the doubly linked list because it has been recently used.
//    d. Return the value of the node.
//    e. If the key does not exist, return -1.

// Step 5: Implement the 'put(key, value)' operation:
//    a. Check if the 'key' already exists in the 'cache'.
//    b. If the key exists, update the value of the corresponding doubly linked list node and move it to the head of the list.
//    c. If the key does not exist:
//        i. Create a new doubly linked list node with the given 'key' and 'value'.
//        ii. Add this new node to the head of the doubly linked list.
//        iii. Add the key-node mapping to the 'cache' HashMap.
//        iv. If the number of keys in the 'cache' exceeds the 'capacity', remove the least recently used node (the tail node before the sentinel tail) from the doubly linked list and remove its corresponding key from the 'cache' HashMap.

// Step 6: Helper functions for doubly linked list operations:
//    a. 'addToHead(node)': Adds a node to the head of the doubly linked list.
//    b. 'removeNode(node)': Removes a given node from the doubly linked list.
//    c. 'moveToHead(node)': Moves a given node to the head of the doubly linked list.
//    d. 'popTail()': Removes and returns the tail node (least recently used) from the doubly linked list.

// Optimal Solution:
// Using a HashMap for O(1) average time complexity lookups and a doubly linked list for O(1) average time complexity for moving nodes and evicting the least recently used node satisfies the O(1) average time complexity requirement for both get and put operations.

// Time Complexity: O(1) average time complexity for get and put operations due to HashMap lookups and doubly linked list manipulations.
// Space Complexity: O(capacity), as the HashMap and doubly linked list will store at most 'capacity' number of key-value pairs.

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, DoublyListNode> cache;
    private final DoublyListNode head, tail;

    private static class DoublyListNode {
        int key, value;
        DoublyListNode prev, next;

        public DoublyListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new DoublyListNode(0, 0);
        this.tail = new DoublyListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DoublyListNode node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoublyListNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoublyListNode newNode = new DoublyListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            if (cache.size() > capacity) {
                DoublyListNode tailNode = popTail();
                cache.remove(tailNode.key);
            }
        }
    }

    private void addToHead(DoublyListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoublyListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoublyListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DoublyListNode popTail() {
        DoublyListNode tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
}