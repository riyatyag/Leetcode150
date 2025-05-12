/**
     * Problem Statement:
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Can you solve it without sorting?
     *
     * Approach:
     * We can use a min-heap of size k to keep track of the k largest elements seen so far.
     * Iterate through the array. For each element:
     * 1. If the heap size is less than k, add the element to the heap.
     * 2. If the heap size is equal to k and the current element is greater than the smallest element in the heap (the root of the min-heap), then remove the smallest element and add the current element.
     * After iterating through the entire array, the root of the min-heap will be the kth largest element.
     *
     * Time Complexity: O(n log k) where n is the length of the input array and k is the given integer. For each of the n elements, heap operations (offer and poll) take O(log k) time.
     * Space Complexity: O(k) to store the min-heap of size k.
     *
     * Optimal Solution:
     * The provided solution implements the min-heap approach.
     **/
    import java.util.PriorityQueue;

     class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}