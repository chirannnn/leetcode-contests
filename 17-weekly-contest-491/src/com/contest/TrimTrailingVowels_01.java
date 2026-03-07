/*
You are given a string s that consists of lowercase English letters.

Return the string obtained by removing all trailing vowels from s.

The vowels consist of the characters 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "idea"
Output: "id"
Explanation:
Removing "idea", we obtain the string "id".

Example 2:
Input: s = "day"
Output: "day"
Explanation:
There are no trailing vowels in the string "day".

Example 3:
Input: s = "aeiou"
Output: ""
Explanation:
Removing "aeiou", we obtain the string "".

Constraints:
1 <= s.length <= 100
s consists of only lowercase English letters.
 */

package com.contest;

public class TrimTrailingVowels_01 {
    public static void main(String[] args) {
        String s = "aeiouj";
        System.out.println(trimTrailingVowels(s));
    }

    static String trimTrailingVowels(String s) {
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                i--;
            } else {
                break;
            }
        }
        return s.substring(0, i + 1);
    }
}
