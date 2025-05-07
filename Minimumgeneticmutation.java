    /**
     * Problem Statement: Find the minimum number of mutations needed to mutate from startGene to endGene, where one mutation is a single character change, and all intermediate genes must be in the given bank.
     *
     * Approach:
     * Use Breadth-First Search (BFS). The startGene is the initial node, and the goal is to reach endGene. Each valid mutation (present in the bank) represents an edge. We want to find the shortest path.
     * Use a set to store the valid genes from the bank for efficient lookup.
     * Use a queue to perform BFS, storing the current gene string and the number of mutations made so far.
     * Maintain a visited set to avoid cycles and redundant processing of gene strings.
     * For each gene in the queue, generate all possible single-character mutations ('A', 'C', 'G', 'T' at each of the 8 positions).
     * If a mutated gene is the endGene, return the current mutation count + 1.
     * If a mutated gene is in the bank and has not been visited, add it to the queue with an incremented mutation count and mark it as visited.
     * If the queue becomes empty and the endGene is not reached, return -1.
     *
     * Time Complexity: O(B * L * 4), where B is the number of genes in the bank, L is the length of the gene string (8), and 4 is the number of possible nucleotide changes at each position. In the worst case, we might explore all possible mutations of each gene in the bank.
     *
     * Space Complexity: O(B), to store the gene bank in a set and the visited set, and for the queue in the worst case.
     *
     * Optimal Solution: BFS is suitable for finding the shortest path in this type of problem.
     */
    class Solution {
       public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                char[] geneChars = currentGene.toCharArray();
                for (int j = 0; j < geneChars.length; j++) {
                    char originalChar = geneChars[j];
                    for (char gene : genes) {
                        geneChars[j] = gene;
                        String nextGene = new String(geneChars);
                        if (geneBank.contains(nextGene) && !visited.contains(nextGene)) {
                            visited.add(nextGene);
                            queue.offer(nextGene);
                        }
                    }
                    geneChars[j] = originalChar;
                }
            }
            mutations++;
        }

        return -1;
    }
}