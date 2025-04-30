//  Problem Statement:
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

//  Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

//  Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

//  Approach (Sorting and Merging):
// 1. Sort the intervals by their starting values. This ensures that we can easily compare the intervals in order.
// 2. Iterate through the sorted intervals: 
//    - If the merged list is empty or if the current interval does not overlap with the last interval in the merged list, add it to the merged list.
//    - If the current interval overlaps with the last interval in the merged list, update the end of the last merged interval to the maximum end value between the two intervals.
// 3. Return the merged list.

//  Time Complexity: O(n log n), where n is the number of intervals. The sorting step dominates the complexity.
//  Space Complexity: O(n), for storing the result in a new list of merged intervals.



class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
