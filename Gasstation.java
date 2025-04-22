/*
Problem Statement:
There are n gas stations along a circular route. Each station i has:
- gas[i] amount of gas available.
- cost[i] amount of gas needed to travel from station i to (i + 1) mod n.
You start at an empty tank at one station. Find the starting gas station index such that you can travel around the circuit once. If it’s not possible, return -1.
It is guaranteed that if a solution exists, it is unique.

Example:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1

Constraints:
- 1 <= n <= 10^5
- 0 <= gas[i], cost[i] <= 10^4

Approach:
- Track the total gas and total cost over the entire route.
- If total gas < total cost, then return -1 (not possible to complete the circuit).
- Otherwise, use a greedy approach:
  - Start from station 0, track the current tank.
  - If at any point the current tank goes below 0, it means we can't reach the next station from the current start index.
  - Reset start index to the next station and reset current tank.

Pseudocode:
1. Initialize totalTank = 0, currTank = 0, startIndex = 0
2. For each station i:
      fuelGain = gas[i] - cost[i]
      totalTank += fuelGain
      currTank += fuelGain
      if currTank < 0:
          startIndex = i + 1
          currTank = 0
3. If totalTank >= 0:
      return startIndex
   Else:
      return -1

Optimal Solution:
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

class Gasstation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int fuelGain = gas[i] - cost[i];
            totalTank += fuelGain;
            currTank += fuelGain;

            if (currTank < 0) {
                startIndex = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}
