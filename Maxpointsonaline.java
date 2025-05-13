/**
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
     * return the maximum number of points that lie on the same straight line.
     *
     * Approach:
     * Iterate through each point in the input array. For each point, consider it as a potential
     * point on a line. Then, iterate through all other points and calculate the slope between
     * the current point and every other point. Points with the same slope with respect to the
     * current point lie on the same line. Keep track of the maximum number of points found on
     * any line passing through the current point. The overall maximum across all starting points
     * will be the result. Handle vertical lines (infinite slope) separately.
     *
     * Time Complexity: O(n^2), where n is the number of points. The outer loop iterates through
     * all n points, and the inner loop also iterates through approximately n points in the worst case.
     * Calculating the slope and updating the count takes constant time.
     *
     * Space Complexity: O(n) in the worst case, to store the slopes in the HashMap for each point.
     *
     * Optimal Solution: The approach described above is generally considered the optimal approach
     * for this problem within the given constraints.
     */

import java.util.*;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        
        int maxPointsOnLine = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; 
            int vertical = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                } else if (dx == 0) {
                    vertical++;
                } else {
                    int gcd = gcd(dy, dx);
                    String slope = (dy / gcd) + "/" + (dx / gcd);
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                }
            }
           int localMax = vertical;
            for (int count : slopeMap.values()) {
                localMax = Math.max(localMax, count);
            }
       maxPointsOnLine = Math.max(maxPointsOnLine, localMax + duplicate);
        }
       return maxPointsOnLine;
    }
      private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
