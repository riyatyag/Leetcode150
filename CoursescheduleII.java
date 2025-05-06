    /**
     * Problem Statement:
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you
     * must take course bi first if you want to take course ai.
     * Return the ordering of courses you should take to finish all courses. If there are many
     * valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     *
     * Approach:
     * This problem can be solved using topological sorting. We can represent the courses and their
     * dependencies as a directed graph. The nodes are the courses, and a directed edge from b to a
     * exists if course a has a prerequisite of course b. A topological sort of this graph gives a linear
     * ordering of nodes such that for every directed edge from node u to node v, node u comes before
     * node v in the ordering. If a cycle exists in the graph, a topological sort is not possible,
     * which means it's impossible to finish all courses.
     * We can use Kahn's algorithm for topological sorting. This involves the following steps:
     * 1. Calculate the in-degree of each node (the number of incoming edges).
     * 2. Add all nodes with an in-degree of 0 to a queue.
     * 3. While the queue is not empty, dequeue a node, add it to the result list, and decrement the
     * in-degree of all its neighbors. If the in-degree of any neighbor becomes 0, enqueue it.
     * 4. If the number of nodes in the result list is equal to the total number of courses, return the list.
     * Otherwise, a cycle exists, and we return an empty array.
     *
     * Time Complexity:
     * Building the graph and in-degree array takes O(numCourses + prerequisites.length) time.
     * The topological sort process involves visiting each node and each edge once, which takes
     * O(numCourses + prerequisites.length) time.
     * Overall time complexity is O(numCourses + prerequisites.length).
     *
     * Space Complexity:
     * The adjacency list `graph` takes O(numCourses + prerequisites.length) space.
     * The `inDegree` array takes O(numCourses) space.
     * The queue can hold up to O(numCourses) nodes.
     * The result list takes O(numCourses) space.
     * Overall space complexity is O(numCourses + prerequisites.length).
     *
     * Optimal Solution:
     * The provided solution uses Kahn's algorithm for topological sorting, which is an efficient and
     * standard approach for this problem.
     */

     import java.util.ArrayList;
     import java.util.LinkedList;  
     import java.util.List;
     import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int preCourse = prereq[1];
            graph[preCourse].add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[count++] = course;

            for (int neighbor : graph[course]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}