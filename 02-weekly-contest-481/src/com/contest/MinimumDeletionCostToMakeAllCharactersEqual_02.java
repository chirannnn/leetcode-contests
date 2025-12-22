/*
You are given a string s of length n and an integer array cost of the same length, where cost[i] is the cost to delete the ith character of s.

You may delete any number of characters from s (possibly none), such that the resulting string is non-empty and consists of equal characters.

Return an integer denoting the minimum total deletion cost required.

Example 1:
Input: s = "aabaac", cost = [1,2,3,4,1,10]
Output: 11
Explanation:
Deleting the characters at indices 0, 1, 2, 3, 4 results in the string "c", which consists of equal characters, and the total cost is cost[0] + cost[1] + cost[2] + cost[3] + cost[4] = 1 + 2 + 3 + 4 + 1 = 11.

Example 2:
Input: s = "abc", cost = [10,5,8]
Output: 13
Explanation:
Deleting the characters at indices 1 and 2 results in the string "a", which consists of equal characters, and the total cost is cost[1] + cost[2] = 5 + 8 = 13.

Example 3:
Input: s = "zzzzz", cost = [67,67,67,67,67]
Output: 0
Explanation:
All characters in s are equal, so the deletion cost is 0.

Constraints:
n == s.length == cost.length
1 <= n <= 105
1 <= cost[i] <= 109
s consists of lowercase English letters.
 */

package com.contest;

public class MinimumDeletionCostToMakeAllCharactersEqual_02 {
    public static void main(String[] args) {
        String s = "zzzzz";
        int[] cost = {67,67,67,67,67};

        System.out.println(minCost(s, cost));
    }

    /*
Approach:
- Final string must be non-empty and contain only ONE unique character.
- So we try keeping only one character ('a' to 'z') and delete all others.
- For each character:
    - Keep all its occurrences
    - Delete everything else
- Choose the character that gives minimum deletion cost.
*/

    static long minCost(String s, int[] cost) {
        int n = cost.length;

        long total = 0;
        for (int cst : cost) {
            total += cst;
        }

        long minDel = Long.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');

            long keep = 0;
            for (int j = 0; j < n; j++) {
                if (ch == s.charAt(j)) {
                    keep += cost[j];
                }
            }

            long del = total - keep;
            minDel = Math.min(del, minDel);
        }
        return minDel;
    }
}
