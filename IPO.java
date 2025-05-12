/**
     * Problem Statement:
     * Suppose LeetCode will start its IPO soon. It has n projects with given profits and capital requirements.
     * With an initial capital w, LeetCode can finish at most k distinct projects.
     * The goal is to maximize the total capital after finishing at most k projects.
     *
     * Approach:
     * We can use a greedy approach combined with a priority queue.
     * First, we pair each project's profit with its capital requirement and sort these pairs based on capital.
     * We maintain a max-heap to store the profits of the projects that can be started with the current capital.
     * We iterate at most k times (for each project we can choose). In each iteration:
     * 1. We add all the projects that can be started with the current capital to the max-heap.
     * 2. If the max-heap is not empty, it means there are projects we can afford. We choose the project with the maximum profit from the heap, add its profit to our current capital, and decrement k.
     * 3. If the max-heap is empty and k > 0, it means we cannot start any more projects with the current capital, so we break the loop.
     * Finally, we return the maximized capital.
     *
     * Time Complexity: O(n log n + k log n) where n is the number of projects. Sorting takes O(n log n), and in the worst case, we might add and remove n elements from the priority queue k times, taking O(k log n).
     * Space Complexity: O(n) to store the project pairs and the elements in the priority queue.
     *
     * Optimal Solution:
     * The provided solution implements the described greedy approach using sorting and a max-heap.
     */

     import java.util.Arrays;
     import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableProfits = new PriorityQueue<>((a, b) -> b - a);
        int projectsIndex = 0;

        for (int i = 0; i < k; i++) {
            while (projectsIndex < n && projects[projectsIndex][0] <= w) {
                availableProfits.offer(projects[projectsIndex][1]);
                projectsIndex++;
            }

            if (availableProfits.isEmpty()) {
                break;
            }

            w += availableProfits.poll();
        }

        return w;
    }
}