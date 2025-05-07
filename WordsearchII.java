    /**
     * Problem Statement: Given an m x n board of characters and a list of strings words, return all words on the board.
     * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     *
     * Approach:
     * 1. Build a Trie with the given list of words. This allows for efficient prefix checking.
     * 2. Iterate through each cell of the board.
     * 3. For each cell, start a Depth-First Search (DFS) to explore possible words starting from that cell.
     * 4. In the DFS, keep track of the current path (prefix) and the visited cells to avoid reusing them.
     * 5. If the current prefix exists in the Trie, continue exploring adjacent cells.
     * 6. If the current prefix is a complete word in the Trie, add it to the result list. Ensure not to add duplicates.
     * 7. Backtrack after exploring each path to explore other possibilities.
     *
     * Time Complexity: O(M * N * 4^L), where M is the number of rows, N is the number of columns, and L is the maximum length of a word in the words list. In the worst case, from each cell, we might explore all possible paths of maximum word length.
     *
     * Space Complexity: O(W * K + M * N), where W is the number of words and K is the average length of the words (for the Trie), and O(M * N) for the visited set in the DFS.
     *
     * Optimal Solution: The Trie-based DFS approach is generally considered optimal for this problem.
     */
    class Solution {
        class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.word = word;
        }
        return root;
    }

    private List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, visited, result);
            }
        }
        return new ArrayList<>(new HashSet<>(result));
    }

    private void dfs(char[][] board, int row, int col, TrieNode node, boolean[][] visited, List<String> result) {
        int m = board.length;
        int n = board[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || !node.children.containsKey(board[row][col])) {
            return;
        }

        char currentChar = board[row][col];
        TrieNode nextNode = node.children.get(currentChar);

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

        visited[row][col] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            dfs(board, row + dr[i], col + dc[i], nextNode, visited, result);
        }

        visited[row][col] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        return findWords(board, words);
    }
}