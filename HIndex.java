// Problem Statement:
// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
// return the researcher's h-index.
//
// The h-index is defined as the maximum value of h such that the given researcher has published at least h papers 
// that have each been cited at least h times.

// Example 1:
// Input: citations = [3,0,6,1,5]
// Output: 3
// Explanation: The researcher has 5 papers. Three of them have at least 3 citations each.

// Example 2:
// Input: citations = [1,3,1]
// Output: 1

// Constraints:
// - n == citations.length
// - 1 <= n <= 5000
// - 0 <= citations[i] <= 1000

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);  
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;  
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();

        int[] testCase1 = {3, 0, 6, 1, 5};
        System.out.println("H-index for test case 1: " + solution.hIndex(testCase1)); // Output: 3

        int[] testCase2 = {1, 3, 1};
        System.out.println("H-index for test case 2: " + solution.hIndex(testCase2)); // Output: 1

        int[] testCase3 = {0, 0, 0, 0};
        System.out.println("H-index for test case 3: " + solution.hIndex(testCase3)); // Output: 0

        int[] testCase4 = {10, 8, 5, 4, 3};
        System.out.println("H-index for test case 4: " + solution.hIndex(testCase4)); // Output: 4

        int[] testCase5 = {25, 8, 5, 3, 3};
        System.out.println("H-index for test case 5: " + solution.hIndex(testCase5)); // Output: 3
    }
}

/*
Optimal Approach:
- First, sort the array in ascending order.
- Then, iterate from the beginning, and for each index `i`, calculate how many papers are remaining: `h = n - i`.
- If `citations[i] >= h`, then h is a valid h-index, return it.
- If no such index found, return 0.

Pseudocode:
1. Sort the array.
2. Loop through the sorted array:
    a. For each index i, calculate h = n - i.
    b. If citations[i] >= h, return h.
3. If loop completes, return 0.
*/
