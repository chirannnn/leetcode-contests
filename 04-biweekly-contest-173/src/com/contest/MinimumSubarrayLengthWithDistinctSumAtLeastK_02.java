/*
You are given an integer array nums and an integer k.

Return the minimum length of a subarray whose sum of the distinct values present in that subarray (each value counted once) is at least k. If no such subarray exists, return -1.

Example 1:
Input: nums = [2,2,3,1], k = 4
Output: 2
Explanation:
The subarray [2, 3] has distinct elements {2, 3} whose sum is 2 + 3 = 5, which is ​​​​​​​at least k = 4. Thus, the answer is 2.

Example 2:
Input: nums = [3,2,3,4], k = 5
Output: 2
Explanation:
The subarray [3, 2] has distinct elements {3, 2} whose sum is 3 + 2 = 5, which is ​​​​​​​at least k = 5. Thus, the answer is 2.

Example 3:
Input: nums = [5,5,4], k = 5
Output: 1
Explanation:
The subarray [5] has distinct elements {5} whose sum is 5, which is at least k = 5. Thus, the answer is 1.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 109
 */

package com.contest;

public class MinimumSubarrayLengthWithDistinctSumAtLeastK_02 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        int k = 4;

        System.out.println(minLength(nums, k));
    }

    static int minLength(int[] nums, int k) {
        int n = nums.length;

        int[] hash = new int[100001];

        long sum = 0;
        int l = 0, r = 0, len = Integer.MAX_VALUE;
        while (r < n) {
            int val = nums[r];

            hash[val]++;
            if (hash[val] == 1) {
                sum += val;
            }

            while (sum >= k) {
                len = Math.min(len, r - l + 1);

                int remove = nums[l];
                hash[remove]--;
                if (hash[remove] == 0) {
                    sum -= remove;
                }
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}
