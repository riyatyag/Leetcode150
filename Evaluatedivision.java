/**
     * Problem Statement:
     * You are given a list of variable pairs (equations) and a list of real numbers (values),
     * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
     * Each Ai or Bi is a string that represents a single variable.
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query
     * where you must find the answer for Cj / Dj = ?.
     * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
     *
     * Approach:
     * We can represent the relationships between variables as a graph where variables are nodes
     * and the division factor between them is the weight of the edge. Since the relationship
     * is bidirectional (if a/b = k, then b/a = 1/k), the graph will have directed edges.
     * To answer a query Cj / Dj, we need to find a path from Cj to Dj in the graph. The result
     * will be the product of the weights of the edges along the path. If no path exists, the
     * answer is -1.0. We can use Depth First Search (DFS) to find the path and calculate the result.
     *
     * Time Complexity:
     * Building the graph takes O(E) time, where E is the number of equations.
     * For each query, in the worst case, we might visit all the nodes and edges in the graph,
     * which can be O(V + E), where V is the number of unique variables. If there are Q queries,
     * the total time complexity for processing queries is O(Q * (V + E)).
     * Overall time complexity is O(E + Q * (V + E)).
     *
     * Space Complexity:
     * The graph is stored in a hash map, which can take O(V + E) space in the worst case.
     * The visited set in DFS can take O(V) space.
     * The result array for queries takes O(Q) space.
     * Overall space complexity is O(V + E + Q).
     *
     * Optimal Solution:
     * The provided solution uses a graph-based approach with DFS to evaluate the division of variables.
     * The time and space complexity are as analyzed above. This approach is generally efficient for
     * this type of problem.
     */

     import java.util.HashMap;
     import java.util.List;
     import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(graph, start, end, new HashMap<>());
            }
        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, Map<String, Boolean> visited) {
        visited.put(current, true);
        if (graph.containsKey(current) && graph.get(current).containsKey(target)) {
            return graph.get(current).get(target);
        }

        if (graph.containsKey(current)) {
            for (Map.Entry<String, Double> neighborEntry : graph.get(current).entrySet()) {
                String neighbor = neighborEntry.getKey();
                double value = neighborEntry.getValue();
                if (!visited.containsKey(neighbor)) {
                    double result = dfs(graph, neighbor, target, visited);
                    if (result != -1.0) {
                        return value * result;
                    }
                }
            }
        }
        return -1.0;
    }
}