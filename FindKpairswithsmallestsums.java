/**
     * Problem Statement:
     * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
     * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
     * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
     *
     * Approach:
     * We can use a min-heap to store the potential k smallest pairs.
     * We start by adding the pairs formed by the first element of nums1 and the first k (or all if k > length of nums2) elements of nums2 into the min-heap.
     * The min-heap will prioritize pairs with smaller sums.
     * Then, we repeatedly extract the pair with the smallest sum from the heap and add it to our result list.
     * When we extract a pair (u, v) from the heap where u is nums1[i] and v is nums2[j], we should consider the next possible pair involving u, which is (nums1[i], nums2[j+1]), and add it to the heap if j+1 is within the bounds of nums2 and we haven't added a pair with this nums1[i] and a larger index in nums2 before. To avoid duplicates and ensure we explore efficiently, we can keep track of the indices of nums2 we've paired with each element of nums1.
     *
     * Time Complexity: O(k log k) in the worst case, as we might add up to k pairs in the priority queue and each operation takes O(log k) time.
     * Space Complexity: O(k) to store the k smallest pairs and the elements in the priority queue.
     *
     * Optimal Solution:
     * The provided solution implements the min-heap approach.
     */

     import java.util.ArrayList;
     import java.util.List;
     import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        boolean[][] visited = new boolean[nums1.length][nums2.length];

        minHeap.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[0];
            int j = current[1];

            result.add(List.of(nums1[i], nums2[j]));
            k--;

            if (i + 1 < nums1.length && !visited[i + 1][j]) {
                minHeap.offer(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }
            if (j + 1 < nums2.length && !visited[i][j + 1]) {
                minHeap.offer(new int[]{i, j + 1});
                visited[i][j + 1] = true;
            }
        }

        return result;
    }
}