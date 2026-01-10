/*
You are given a string array words, consisting of distinct 4-letter strings, each containing lowercase English letters.

A word square consists of 4 distinct words: top, left, right and bottom, arranged as follows:

top forms the top row.
bottom forms the bottom row.
left forms the left column (top to bottom).
right forms the right column (top to bottom).
It must satisfy:

top[0] == left[0], top[3] == right[0]
bottom[0] == left[3], bottom[3] == right[3]
Return all valid distinct word squares, sorted in ascending lexicographic order by the 4-tuple (top, left, right, bottom)​​​​​​​.

Example 1:
Input: words = ["able","area","echo","also"]
Output: [["able","area","echo","also"],["area","able","also","echo"]]
Explanation:
There are exactly two valid 4-word squares that satisfy all corner constraints:
"able" (top), "area" (left), "echo" (right), "also" (bottom)
top[0] == left[0] == 'a'
top[3] == right[0] == 'e'
bottom[0] == left[3] == 'a'
bottom[3] == right[3] == 'o'
"area" (top), "able" (left), "also" (right), "echo" (bottom)
All corner constraints are satisfied.
Thus, the answer is [["able","area","echo","also"],["area","able","also","echo"]].

Example 2:
Input: words = ["code","cafe","eden","edge"]
Output: []
Explanation:
No combination of four words satisfies all four corner constraints. Thus, the answer is empty array [].

Constraints:
4 <= words.length <= 15
words[i].length == 4
words[i] consists of only lowercase English letters.
All words[i] are distinct.
 */

package com.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquaresII_02 {
    public static void main(String[] args) {
        String[] words = {"able","area","echo","also"};

        List<List<String >> res = wordSquares(words);
        System.out.println(res);
    }

    static List<List<String >> wordSquares(String[] words) {
        int n = words.length;

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;

                        String top = words[i], left = words[j], right = words[k], bottom = words[l];

                        if (top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) && bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)) {
                            ans.add(Arrays.asList(top, left, right, bottom));
                        }
                    }
                }
            }
        }

        ans.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                int compare = a.get(i).compareTo(b.get(i));
                if (compare != 0) return compare;
            }
            return 0;
        });
        return ans;
    }
}
