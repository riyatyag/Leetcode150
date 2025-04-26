// ✅ Problem Statement:
// You are given a string `s`.
// A phrase is a palindrome if after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// You need to return `true` if `s` is a palindrome, otherwise return `false`.

// ✅ Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: After cleaning and lowering case => "amanaplanacanalpanama", which is a palindrome.

// ✅ Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: After cleaning => "raceacar", which is not a palindrome.

// ✅ Example 3:
// Input: s = " "
// Output: true
// Explanation: Empty string is considered a palindrome.

// ✅ Approach:
// 1. First, convert the entire string to lowercase.
// 2. Use two pointers, `left` starting from the beginning and `right` starting from the end.
// 3. Ignore non-alphanumeric characters while moving the pointers.
// 4. Compare characters at `left` and `right` positions:
//    - If they are not equal, return false.
//    - If they are equal, continue moving inward.
// 5. If all characters match till the middle, return true.

// ✅ Pseudo Code:
// - Convert s to lowercase.
// - Initialize left = 0, right = s.length() - 1
// - While left < right:
//     - If s[left] is not alphanumeric, move left forward.
//     - If s[right] is not alphanumeric, move right backward.
//     - Compare s[left] and s[right], if not same return false.
//     - Else move left++, right--
// - Return true.

// ✅ Time Complexity: O(n)
// where n = length of the string s, because we visit each character at most once.

// ✅ Space Complexity: O(1)
// because we are not using any extra space except a few variables.

class Solution {
    public boolean isPalindrome(String s) {
        return check(s.toLowerCase(), 0, s.length() - 1);
    }

    private boolean check(String s, int left, int right) {
        if (left >= right) return true;

        char lChar = s.charAt(left);
        char rChar = s.charAt(right);

        if (!Character.isLetterOrDigit(lChar)) {
            return check(s, left + 1, right);
        }
        if (!Character.isLetterOrDigit(rChar)) {
            return check(s, left, right - 1);
        }
        if (lChar != rChar) {
            return false;
        }
        return check(s, left + 1, right - 1);
    }
}
