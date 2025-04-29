
//  Problem Statement:
// Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

//  Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//  Example 2:
// Input: strs = [""]
// Output: [[""]]

//  Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

//  Constraints:
// - 1 <= strs.length <= 10^4
// - 0 <= strs[i].length <= 100
// - strs[i] consists of lowercase English letters only.

//  Approach:
// 1. For each string in the array, sort its characters to generate a common key for anagrams.
// 2. Use a HashMap where the key is the sorted string and the value is a list of strings (anagram group).
// 3. Collect all values from the map and return them as the result.

//  Time Complexity: O(n * k log k)
//     where n = number of strings, k = max length of a string.
//     Sorting each string takes O(k log k).
//  Space Complexity: O(n * k) to store the grouped anagrams in the map and result list.



class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
