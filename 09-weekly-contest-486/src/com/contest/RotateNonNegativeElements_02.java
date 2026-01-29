/*
You are given an integer array nums and an integer k.

Rotate only the non-negative elements of the array to the left by k positions, in a cyclic manner.

All negative elements must stay in their original positions and must not move.

After rotation, place the non-negative elements back into the array in the new order, filling only the positions that originally contained non-negative values and skipping all negative positions.

Return the resulting array.

Example 1:
Input: nums = [1,-2,3,-4], k = 3
Output: [3,-2,1,-4]
Explanation:​​​​​​​
The non-negative elements, in order, are [1, 3].
Left rotation with k = 3 results in:
[1, 3] -> [3, 1] -> [1, 3] -> [3, 1]
Placing them back into the non-negative indices results in [3, -2, 1, -4].

Example 2:
Input: nums = [-3,-2,7], k = 1
Output: [-3,-2,7]
Explanation:
The non-negative elements, in order, are [7].
Left rotation with k = 1 results in [7].
Placing them back into the non-negative indices results in [-3, -2, 7].

Example 3:
Input: nums = [5,4,-9,6], k = 2
Output: [6,5,-9,4]
Explanation:
The non-negative elements, in order, are [5, 4, 6].
Left rotation with k = 2 results in [6, 5, 4].
Placing them back into the non-negative indices results in [6, 5, -9, 4].

Constraints:
1 <= nums.length <= 105
-105 <= nums[i] <= 105
0 <= k <= 105
 */

package com.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateNonNegativeElements_02 {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-4}; int k = 3;

        System.out.println(Arrays.toString(rotateElements(nums, k)));
    }

    static int[] rotateElements(int[] nums, int k) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) if (nums[i] >= 0) list.add(nums[i]);

        int m = list.size();
        if (m == 0) return nums;

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = list.get(i);

        k = k % m;
        reverse(arr, 0, k - 1);
        reverse(arr, k, m - 1);
        reverse(arr, 0, m - 1);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) nums[i] = arr[idx++];
        }
        return nums;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
