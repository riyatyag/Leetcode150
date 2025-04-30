//  Problem Statement:
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represents the start and the end of the ith interval.
// The intervals are sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
// Return the resulting intervals after the insertion.

//  Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

//  Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

//  Approach:
// 1. First, add all intervals that end before the new interval starts (non-overlapping).
// 2. Then, merge the new interval with any overlapping intervals.
// 3. Finally, add any remaining intervals that start after the new interval ends (non-overlapping).

//  Time Complexity: O(n), where n is the number of intervals. We only go through the intervals once.
// Space Complexity: O(n), for storing the result in a list.


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
