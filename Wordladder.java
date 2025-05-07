    /**
     * Problem Statement: Find the number of words in the shortest transformation sequence from beginWord to endWord using a dictionary wordList, such that every adjacent pair of words differs by a single letter, and every word in the sequence (except beginWord) is in wordList.
     *
     * Approach:
     * Use Breadth-First Search (BFS). Start with the beginWord and explore its neighbors (words that differ by one letter and are in wordList). Keep track of the level (number of transformations).
     * Use a set to store the wordList for efficient lookup.
     * Use a queue for BFS, storing the current word.
     * Maintain a visited set to avoid cycles and redundant processing.
     * For each word in the queue, generate all possible one-letter transformations.
     * If a transformation is in wordList and not visited, add it to the queue and mark it as visited.
     * The level increases by one after each level of BFS.
     * If the endWord is reached, return the current level.
     * If the queue becomes empty and the endWord is not reached, return 0.
     *
     * Time Complexity: O(M * N * 26), where M is the number of words in wordList and N is the length of each word. For each word in the queue, we generate all possible one-letter transformations (N positions, 26 possible letters). In the worst case, we might visit all words in wordList.
     *
     * Space Complexity: O(M), to store the wordList in a set and the visited set, and for the queue in the worst case.
     *
     * Optimal Solution: The BFS approach is optimal for finding the shortest path in an unweighted graph, which this problem can be modeled as (where words are nodes and an edge exists between two words if they differ by one letter).
     */
    class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level;
                }

                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }
}