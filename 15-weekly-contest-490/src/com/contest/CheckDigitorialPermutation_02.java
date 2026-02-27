/*
You are given an integer n.

A number is called digitorial if the sum of the factorials of its digits is equal to the number itself.

Determine whether any permutation of n (including the original order) forms a digitorial number.

Return true if such a permutation exists, otherwise return false.

Note:
The factorial of a non-negative integer x, denoted as x!, is the product of all positive integers less than or equal to x, and 0! = 1.
A permutation is a rearrangement of all the digits of a number that does not start with zero. Any arrangement starting with zero is invalid.

Example 1:
Input: n = 145
Output: true
Explanation:
The number 145 itself is digitorial since 1! + 4! + 5! = 1 + 24 + 120 = 145. Thus, the answer is true.

Example 2:
Input: n = 10
Output: false
Explanation:​​​​​​​
10 is not digitorial since 1! + 0! = 2 is not equal to 10, and the permutation "01" is invalid because it starts with zero.

Constraints:
1 <= n <= 109
 */
package com.contest;

public class CheckDigitorialPermutation_02 {
    public static void main(String[] args) {
        int n = 415;
        System.out.println(isDigitorialPermutation(n));
    }

    private static boolean isDigitorialPermutation(int n) {
        int temp = n;
        int digitFact = 0;
        while (temp > 0) {
            int rem = temp % 10;
            digitFact += factorial(rem);
            temp /= 10;
        }
        
        return isValid(n, digitFact);
    }

    private static boolean isValid(int n, int digitFact) {
        int[] arr = new int[10];
        while (n > 0) {
            arr[n % 10]++;
            n /= 10;
        }
        while (digitFact > 0) {
            arr[digitFact % 10]--;
            digitFact /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    private static int factorial(int rem) {
        int fact = 1;
        for (int i = 2; i <= rem; i++) {
            fact *= i;
        }
        return fact;
    }
}
