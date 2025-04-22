/*
 Problem Statement:
Implement the RandomizedSet class with the following methods:
1. RandomizedSet() -> Initializes the set.
2. insert(int val) -> Inserts val if not present; returns true if inserted, else false.
3. remove(int val) -> Removes val if present; returns true if removed, else false.
4. getRandom() -> Returns a random element from the current set. Each element must have equal probability.

All operations must be in average O(1) time.

Example:
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]

Output:
[null, true, false, true, 2, true, false, 2]
*/

/*
 Approach:
- Use a HashMap to store value -> index in a list.
- Use an ArrayList to store the elements.
- This helps in achieving O(1) insert, delete and random retrieval.
- For deletion in O(1), we swap the element to be removed with the last element and remove the last one.

 Data Structures Used:
- HashMap<Integer, Integer> → stores the value and its index in list.
- ArrayList<Integer> → stores values for getRandom access.
- Random → to return a random index.

*/

/*
 Pseudocode:

RandomizedSet():
    map = {}
    list = []
    rand = new Random()

insert(val):
    if val exists in map:
        return false
    append val to list
    map[val] = index in list
    return true

remove(val):
    if val not in map:
        return false
    get index of val from map
    get last element in list
    overwrite index with last element
    update map[lastElement] = index
    remove last element from list
    remove val from map
    return true

getRandom():
    return list[random index]
*/

/*
 Optimal Solution:
- Time Complexity:
    • insert() = O(1)
    • remove() = O(1)
    • getRandom() = O(1)
- Space Complexity: O(n) for storing n elements.
*/

import java.util.*;

class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
