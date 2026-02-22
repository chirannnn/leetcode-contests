/*
You are given a string s consisting of lowercase English letters.

A substring is almost-palindromic if it becomes a palindrome after removing exactly one character from it.

Return an integer denoting the length of the longest almost-palindromic substring in s.

Example 1:
Input: s = "abca"
Output: 4
Explanation:
Choose the substring "abca".
Remove "abca".
The string becomes "aba", which is a palindrome.
Therefore, "abca" is almost-palindromic.

Example 2:
Input: s = "abba"
Output: 4
Explanation:
Choose the substring "abba".
Remove "abba".
The string becomes "aba", which is a palindrome.
Therefore, "abba" is almost-palindromic.

Example 3:
Input: s = "zzabba"
Output: 5
Explanation:
Choose the substring "zzabba".
Remove "zabba".
The string becomes "abba", which is a palindrome.
Therefore, "zabba" is almost-palindromic.

Constraints:
2 <= s.length <= 2500
s consists of only lowercase English letters.
 */

package com.contest;

public class LongestAlmostPalindromicSubstring_03 {
    public static void main(String[] args) {
        String s = "zzabba";
        System.out.println(almostPalindromic(s));
    }

    static int almostPalindromic(String s) {
        int n = s.length();

        int maxLen = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
                maxLen = Math.max(maxLen, isPalindrome(arr, i, i));

                maxLen = Math.max(maxLen, isPalindrome(arr, i, i + 1));
        }
        return Math.min(maxLen, n);
    }

    static int isPalindrome(char[] arr, int s, int e) {
        int max = 0;
        int n = arr.length;
        while (s >= 0 && e < n && arr[s] == arr[e]) {
            max = Math.max(max, e - s + 1 + 1);
            s--;
            e++;
        }

        int leftPointer = s - 1, rightPointer = e;
        max = Math.max(max, isPal(arr, leftPointer, rightPointer));

        leftPointer = s; rightPointer = e + 1;
        max = Math.max(max, isPal(arr, leftPointer, rightPointer));

        return max;
    }

    static int isPal(char[] arr, int s, int e) {
        int max = 0;
        while (s >= 0 && e < arr.length && arr[s] == arr[e]) {
            max = Math.max(max, e -s + 1);
            s--;
            e++;
        }
        return max;
    }
}
