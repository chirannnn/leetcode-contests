/*
You are given an integer n.

In one operation, you may split an integer x into two positive integers a and b such that a + b = x.

The cost of this operation is a * b.

Return an integer denoting the minimum total cost required to split the integer n into n ones.

Example 1:
Input: n = 3
Output: 3
Explanation:
One optimal set of operations is:
x	a	b	a + b	a * b	Cost
3	1	2	3	2	2
2	1	1	2	1	1
Thus, the minimum total cost is 2 + 1 = 3.

Example 2:
Input: n = 4
Output: 6
Explanation:
One optimal set of operations is:
x	a	b	a + b	a * b	Cost
4	2	2	4	4	4
2	1	1	2	1	1
2	1	1	2	1	1
Thus, the minimum total cost is 4 + 1 + 1 = 6.

Constraints:
1 <= n <= 500
 */

package com.contest;

public class MinimumCostToSplitIntoOnes_02 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(minCost(n));
    }

    static int minCost(int n) {

        /*
        Intuition
        Multiplying by 1 is always smaller
        Approach
        Any number x, if it is partioned as a + b, where a + b = x
        Always taking the value of a as 1 gives a * b as a smallest multiple
        For Example 6 can be partioned as
        1 + 5 (1 * 5 = 5)
        2 + 4 (2 * 4 = 8)
        3 + 3 (3 * 3 = 9)
        So multiplying by 1 is always smaller
        If you taking 1 digit as 1, then you are summing up till n - 1
        So 1 + 2 + 3 + 4 + 5 = 15, which is n * (n - 1) / 2
        6 * (5) / 2 = 3 * 5 = 15
         */

        return n * (n - 1) / 2;
    }
}
