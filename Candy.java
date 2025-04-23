/*
Problem Statement:
---------------------
There are n children standing in a line, each assigned a rating.
You are to distribute candies to the children such that:
1. Each child must have at least one candy.
2. Children with a higher rating than their immediate neighbors must get more candies than them.

Goal:
-----
Minimize the total number of candies distributed.

Examples:
---------
Input: ratings = [1, 0, 2]
Output: 5
Explanation: candies = [2,1,2]

Input: ratings = [1, 2, 2]
Output: 4
Explanation: candies = [1,2,1]
*/

/*
Approach:
---------
1. Initialize a candies array with 1 for all children.
2. Traverse from left to right:
   - If ratings[i] > ratings[i-1], then candies[i] = candies[i-1] + 1
3. Traverse from right to left:
   - If ratings[i] > ratings[i+1] and candies[i] <= candies[i+1],
     then candies[i] = candies[i+1] + 1
4. Sum up the candies array for the final answer.

Why this works:
---------------
Using a greedy two-pass approach ensures that both left and right neighbor conditions are satisfied
without violating the minimum candy rule.
*/

/*
Pseudo Code:
------------
function candy(ratings):
    n = length of ratings
    candies = array of size n initialized with 1

    // Left to right pass
    for i from 1 to n - 1:
        if ratings[i] > ratings[i - 1]:
            candies[i] = candies[i - 1] + 1

    // Right to left pass
    for i from n - 2 down to 0:
        if ratings[i] > ratings[i + 1] and candies[i] <= candies[i + 1]:
            candies[i] = candies[i + 1] + 1

    return sum of all values in candies
*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
