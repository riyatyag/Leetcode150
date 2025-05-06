     /**
     * Problem Statement:
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
     * must take course bi first if you want to take course ai.
     * Return true if you can finish all courses. Otherwise, return false.
     *
     * Approach:
     * This problem can be modeled as a directed graph where courses are nodes and prerequisites
     * represent directed edges. A cycle in this graph means that there is a circular dependency,
     * making it impossible to finish all courses. Therefore, the problem boils down to detecting
     * whether the directed graph contains a cycle. We can use Depth First Search (DFS) to detect cycles.
     * During DFS, we maintain the state of each node: unvisited, visiting, and visited. If we encounter
     * a node that is currently being visited during the DFS traversal of one of its descendants, we have found a cycle.
     *
     * Time Complexity:
     * Building the adjacency list takes O(P) time, where P is the number of prerequisites.
     * The DFS traversal visits each node and edge at most once. In the worst case, we might perform
     * DFS starting from each node. So, the time complexity of DFS is O(V + E), where V is the number
     * of courses (numCourses) and E is the number of prerequisites.
     * Overall time complexity is O(numCourses + prerequisites.length).
     *
     * Space Complexity:
     * The adjacency list `graph` takes O(numCourses + prerequisites.length) space.
     * The `visited` array takes O(numCourses) space.
     * The recursion stack in DFS can go up to O(numCourses) in the worst case (e.g., a linear chain of courses).
     * Overall space complexity is O(numCourses + prerequisites.length).
     *
     * Optimal Solution:
     * The provided solution uses a graph-based approach with DFS to detect cycles, which is an efficient
     * way to solve this problem.
     */

     import java.util.ArrayList;
     import java.util.List;

      class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(i, graph, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(int course, List<List<Integer>> graph, int[] visited) {
        visited[course] = 1; 

        for (int neighbor : graph.get(course)) {
            if (visited[neighbor] == 1) {
                return true; 
            }
            if (visited[neighbor] == 0) {
                if (isCyclic(neighbor, graph, visited)) {
                    return true;
                }
            }
        }

        visited[course] = 2; 
        return false;
    }
}