//  Problem Statement:
// There are some spherical balloons taped onto a flat wall, represented by a 2D integer array `points` where points[i] = [xstart, xend] 
// denotes a balloon whose horizontal diameter stretches between `xstart` and `xend`.
// You need to find the minimum number of arrows that must be shot to burst all the balloons.
// Arrows are shot directly vertically (in the positive y-direction) from different points along the x-axis. 
// A balloon is burst if an arrow is shot at a point where xstart <= x <= xend.
// There is no limit to the number of arrows that can be shot, and an arrow keeps traveling infinitely along the y-axis.

//  Example 1:
// Input: points = [[10,16],[2,8],[1,6],[7,12]]
// Output: 2
// Explanation: Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6], then shoot another at x = 11, bursting the remaining balloons.

//  Example 2:
// Input: points = [[1,2],[3,4],[5,6],[7,8]]
// Output: 4
// Explanation: Each balloon needs a separate arrow since no balloons overlap.

//  Example 3:
// Input: points = [[1,2],[2,3],[3,4],[4,5]]
// Output: 2
// Explanation: Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3], then shoot another at x = 4, bursting the balloons [3,4] and [4,5].

//  Approach (Greedy Algorithm):
// The key observation is that we can burst multiple balloons with one arrow if the balloons overlap. 
// 1. Sort the balloons based on their ending positions (xend).
// 2. Start with the first balloon, shoot an arrow at its end position (xend).
// 3. For every subsequent balloon, check if it overlaps with the current arrow's position. If it does, no new arrow is needed.
// 4. If a balloon doesn't overlap, shoot a new arrow at its end position.
// 5. Count the total number of arrows needed.

//  Time Complexity: O(n log n) where n is the number of balloons (due to sorting).
//  Space Complexity: O(1), as we are modifying the input array in-place and only using a few variables for tracking.


class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int lastArrowPos = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastArrowPos) {
                arrows++; 
                lastArrowPos = points[i][1];
            }
        }
        
        return arrows;
    }
}
