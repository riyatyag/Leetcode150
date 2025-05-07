    /**
     * Problem Statement: Design a data structure that supports adding new words and finding if a string matches any previously added string.
     * Implement the WordDictionary class:
     * WordDictionary() Initializes the object.
     * void addWord(word) Adds word to the data structure, it can be matched later.
     * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
     *
     * Approach:
     * Use a Trie (Prefix Tree) to store the words. Each node in the Trie will represent a character, and a boolean flag will indicate if a complete word ends at that node.
     * For the addWord operation, traverse the Trie based on the characters of the word. If a character is not present, create a new node. Mark the last node of the word as the end of a word.
     * For the search operation, traverse the Trie based on the characters of the search word. If the character is a '.', explore all possible branches of the current node. Use recursion or iteration to handle the '.' wildcard.
     *
     * Time Complexity:
     * addWord: O(L), where L is the length of the word.
     * search: In the worst case, O(N * L), where N is the number of words in the dictionary and L is the maximum length of a word. However, with the Trie structure, if there are no wildcards, it's O(L). With wildcards, it can explore multiple branches. In the given constraints with at most 2 dots, the complexity is significantly reduced but still depends on the Trie structure.
     *
     * Space Complexity: O(W * L), where W is the number of words and L is the average length of the words, due to the storage of the Trie.
     *
     * Optimal Solution: The Trie-based approach is efficient for prefix-based searches and handling wildcards.
     */

    class WordDictionary {
        private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node != null && node.isWord;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchHelper(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int charIndex = ch - 'a';
            return node.children[charIndex] != null && searchHelper(word, index + 1, node.children[charIndex]);
        }
    }
}