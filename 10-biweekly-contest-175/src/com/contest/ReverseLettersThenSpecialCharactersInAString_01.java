/*
You are given a string s consisting of lowercase English letters and special characters.

Your task is to perform these in order:

Reverse the lowercase letters and place them back into the positions originally occupied by letters.
Reverse the special characters and place them back into the positions originally occupied by special characters.
Return the resulting string after performing the reversals.

Example 1:
Input: s = ")ebc#da@f("
Output: "(fad@cb#e)"
Explanation:
The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
s becomes ")fad#cb@e("
​​​​​​​The special characters in the string are [')', '#', '@', '(']:
Reversing them gives ['(', '@', '#', ')']
s becomes "(fad@cb#e)"

Example 2:
Input: s = "z"
Output: "z"
Explanation:
The string contains only one letter, and reversing it does not change the string. There are no special characters.

Example 3:
Input: s = "!@#$%^&*()"
Output: ")(*&^%$#@!"
Explanation:
The string contains no letters. The string contains all special characters, so reversing the special characters reverses the whole string.

Constraints:
1 <= s.length <= 100
s consists only of lowercase English letters and the special characters in "!@#$%^&*()".
 */

package com.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLettersThenSpecialCharactersInAString_01 {
    public static void main(String[] args) {
        String s = ")ebc#da@f(";

        System.out.println(reverseByType(s));
    }

    static String reverseByType(String s) {
        char[] ch = s.toCharArray();

        int l = 0, r = ch.length - 1;
        // letter swap
        while (l < r) {
            while (l < r && !Character.isLowerCase(ch[l])) l++;
            while (l < r && !Character.isLowerCase(ch[r])) r--;

            if (l < r) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }

        l = 0; r = ch.length - 1;
        // sympol swap
        while (l < r) {
            while (l < r && Character.isLowerCase(ch[l])) l++;
            while (l < r && Character.isLowerCase(ch[r])) r--;

            if (l < r) {
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;
                r--;
            }
        }

        return new String(ch);
    }
}
