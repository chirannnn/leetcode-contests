/*
You are given two integer arrays costs and capacity, both of length n, where costs[i] represents the purchase cost of the ith machine and capacity[i] represents its performance capacity.

You are also given an integer budget.

You may select at most two distinct machines such that the total cost of the selected machines is strictly less than budget.

Return the maximum achievable total capacity of the selected machines.

Example 1:
Input: costs = [4,8,5,3], capacity = [1,5,2,7], budget = 8
Output: 8
Explanation:
Choose two machines with costs[0] = 4 and costs[3] = 3.
The total cost is 4 + 3 = 7, which is strictly less than budget = 8.
The maximum total capacity is capacity[0] + capacity[3] = 1 + 7 = 8.

Example 2:
Input: costs = [3,5,7,4], capacity = [2,4,3,6], budget = 7
Output: 6
Explanation:
Choose one machine with costs[3] = 4.
The total cost is 4, which is strictly less than budget = 7.
The maximum total capacity is capacity[3] = 6.

Example 3:
Input: costs = [2,2,2], capacity = [3,5,4], budget = 5
Output: 9
Explanation:
Choose two machines with costs[1] = 2 and costs[2] = 2.
The total cost is 2 + 2 = 4, which is strictly less than budget = 5.
The maximum total capacity is capacity[1] + capacity[2] = 5 + 4 = 9.

Constraints:
1 <= n == costs.length == capacity.length <= 105
1 <= costs[i], capacity[i] <= 105
1 <= budget <= 2 * 105
 */

package com.leetcode;

import java.util.Arrays;

public class MaximumCapacityWithinBudget_02 {
    public static void main(String[] args) {
        int[] costs = {4,8,5,3}, capacity = {1,5,2,7};
        int budget = 8;

        System.out.println(maxCapacity(costs, capacity, budget));
    }

    static int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = costs[i];
            pairs[i][1] = capacity[i];
        }

        Arrays.sort(pairs, (a, b) -> {
            if (a[0] - b[0] != 0) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] cost_sorted = new int[n];
        int[] capacity_sorted = new int[n];
        for (int i = 0; i < n; i++) {
            cost_sorted[i] = pairs[i][0];
            capacity_sorted[i] = pairs[i][1];
        }

        int[] prefix_cap_sort = new int[n];
        prefix_cap_sort[0] = capacity_sorted[0];
        for (int i = 1; i < n; i++) {
            prefix_cap_sort[i] = Math.max(prefix_cap_sort[i - 1], capacity_sorted[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cost = cost_sorted[i];
            if (cost < budget) {
                ans = Math.max(ans, capacity_sorted[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            int cost = cost_sorted[i];
            int limit = budget - cost;

            int j = search(cost_sorted, limit);
            if (j >= i) {
                j = Math.min(j, i - 1);
            }

            if (j >= 0) {
                ans = Math.max(ans, capacity_sorted[i] + prefix_cap_sort[j]);
            }
        }
        return ans;
    }

    static int search(int[] arr, int cost) {
        int s = 0, e = arr.length - 1;
        int j = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (arr[m] < cost) {
                j = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return j;
    }
}
