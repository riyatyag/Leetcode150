     /**
     * Given a reference of a node in a connected undirected graph.
     * Return a deep copy (clone) of the graph.
     * Each node in the graph contains a value (int) and a list (List<Node>) of its neighbors.
     *
     * Approach:
     * We can use Depth First Search (DFS) or Breadth First Search (BFS) to traverse the original graph.
     * To ensure we create a deep copy and handle cycles correctly, we need to keep track of the nodes we have already cloned.
     * A HashMap can be used to store the mapping between the original nodes and their cloned counterparts.
     *
     * Algorithm using DFS:
     * 1. Create a HashMap to store the mapping of original nodes to their clones.
     * 2. Create a recursive function `cloneNode(node, visited)` where `node` is the current node to clone and `visited` is the HashMap.
     * 3. In `cloneNode`:
     * - If `node` is null, return null.
     * - If `node` is already in `visited`, return its clone from the map.
     * - Create a new clone node with the same value as `node`.
     * - Put the original `node` and its `clone` into the `visited` map.
     * - Iterate through the neighbors of the original `node`.
     * - For each neighbor, recursively call `cloneNode` to get its clone and add it to the neighbors list of the current clone.
     * - Return the `clone` node.
     * 4. The main function `cloneGraph(node)` will initiate the cloning process by calling `cloneNode` with the starting node (given as input) and the initially empty HashMap.
     *
     * Time Complexity: O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph.
     * We visit each node and each edge once.
     *
     * Space Complexity: O(V) in the worst case due to the storage required for the visited HashMap to hold the cloned nodes and the recursion stack during DFS.
     *
     * Optimal Solution: The DFS or BFS approach with a HashMap to keep track of cloned nodes is the standard and optimal way to perform a deep copy of a graph with cycles.
     */


// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }

    private Node cloneNode(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneNode(neighbor, visited));
        }

        return cloneNode;
    }
}