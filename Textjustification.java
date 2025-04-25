//  Problem Statement:
// Given an array of words and a maxWidth,
// format the text so each line has exactly maxWidth characters and is fully justified.

//  Rules:
// 1. Greedily fill as many words as possible in a line without exceeding maxWidth.
// 2. For full justification:
//    - Distribute extra spaces as evenly as possible.
//    - If uneven, more spaces should go to the left.
// 3. The last line should be left-justified, with no extra spaces between words.

//  Example:
// Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
//        maxWidth = 16
// Output:
// [
//   "This    is    an",
//   "example  of text",
//   "justification.  "
// ]

//  Approach:
// 1. Use a loop to group words that can fit in one line.
// 2. Calculate total spaces to add based on number of words in the line.
// 3. Distribute spaces:
//    - If it's the last line or only one word, left-justify.
//    - Else, distribute spaces evenly between words.
// 4. Build each justified line using StringBuilder and add to result list.

//  Time Complexity: O(n), where n is the number of characters across all words.
//  Space Complexity: O(1) extra space (result list excluded).

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLen = words[i].length();

            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            int totalSpaces = maxWidth - lineLen + (numWords - 1);
            StringBuilder line = new StringBuilder();

            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                int remainingSpaces = maxWidth - line.length();
                while (remainingSpaces-- > 0) line.append(" ");
            } else {
                int spaces = (maxWidth - (lineLen - (numWords - 1))) / (numWords - 1);
                int extra = (maxWidth - (lineLen - (numWords - 1))) % (numWords - 1);

                for (int k = i; k < j - 1; k++) {
                    line.append(words[k]);
                    for (int s = 0; s < spaces; s++) line.append(" ");
                    if (extra-- > 0) line.append(" ");
                }
                line.append(words[j - 1]); 
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
