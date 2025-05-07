    /**
     * Problem Statement: Implement the Trie class with insert, search, and startsWith methods.
     * A trie (prefix tree) is a tree data structure used for efficient key storage and retrieval in a string dataset.
     *
     * Approach:
     * Implement a Trie using nested nodes. Each node represents a character, and an array of 26 children pointers (for 'a' to 'z') allows traversal.
     * Each node also has a boolean flag to indicate if a complete word ends at this node.
     *
     * insert(word): Start from the root. For each character in the word, if the corresponding child doesn't exist, create a new node. Move to the child node. Mark the last node of the word as isEndOfWord = true.
     *
     * search(word): Start from the root. For each character in the word, if the corresponding child doesn't exist, the word is not in the trie. If the traversal completes, check if the last node's isEndOfWord is true.
     *
     * startsWith(prefix): Start from the root. For each character in the prefix, if the corresponding child doesn't exist, no word with this prefix exists. If the traversal completes, it means there is at least one word with this prefix.
     *
     * Time Complexity: O(L) for insert, search, and startsWith, where L is the length of the word or prefix. This is because each operation involves traversing at most the length of the input string through the trie.
     *
     * Space Complexity: O(W * L) in the worst case, where W is the number of words and L is the average length of the words. Each character of each word might create a new node in the trie.
     *
     * Optimal Solution: The Trie data structure itself is optimal for prefix-based operations on strings.
     */
    class Trie {
      class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null;
    }
}