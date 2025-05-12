/**
     * Problem Statement:
     * Implement the MedianFinder class to support the following operations:
     * - MedianFinder() initializes the MedianFinder object.
     * - void addNum(int num) adds the integer num from the data stream to the data structure.
     * - double findMedian() returns the median of all elements so far.
     *
     * Approach:
     * We can maintain two priority queues: a max-heap to store the smaller half of the numbers
     * and a min-heap to store the larger half of the numbers.
     * When a new number is added, we first add it to the max-heap. Then, to maintain the balance
     * (the size difference between the two heaps should not be more than 1), we might need to
     * move the largest element from the max-heap to the min-heap.
     * Similarly, if the min-heap becomes larger, we move the smallest element to the max-heap.
     * To find the median:
     * - If the sizes of both heaps are equal, the median is the average of the top elements of both heaps.
     * - If the max-heap has more elements, the median is the top element of the max-heap.
     * - If the min-heap has more elements, the median is the top element of the min-heap.
     *
     * Time Complexity:
     * - addNum(int num): O(log n) due to heap insertion.
     * - findMedian(): O(1) as we only access the top elements of the heaps.
     * Space Complexity: O(n) to store the numbers in the heaps.
     *
     * Optimal Solution:
     * The provided solution implements the two-heap approach using priority queues.
     **/
    /**
  * Follow up optimizations:
 * If all numbers are in the range [0, 100]:
 * We can use an array (or a frequency map) of size 101 to store the counts of each number.
 * To find the median, we can iterate through the array to find the middle element(s) based on the counts.
 * addNum would be O(1), and findMedian would be O(101) which is O(1) as the range is constant.
 *
 * If 99% of numbers are in the range [0, 100]:
 * We can use a hybrid approach. Maintain the frequency map for numbers in the range [0, 100].
 * For the 1% of numbers outside this range, we can store them in two heaps (min and max) as in the original solution.
 * When finding the median, we would first check the frequency map. If the median falls within [0, 100], we calculate it from the frequency map.
 * Otherwise, the median would involve the elements in the heaps. This approach optimizes for the common case.
 */

    import java.util.PriorityQueue;

      class MedianFinder {
         private PriorityQueue<Integer> maxHeap; 
         private PriorityQueue<Integer> minHeap; 

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        minHeap = new PriorityQueue<>();             
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return (double) minHeap.peek();
        }
    }
}

