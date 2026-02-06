/*
You are given a positive integer array nums.

For a positive integer k, define nonPositive(nums, k) as the minimum number of operations needed to make every element of nums non-positive. In one operation, you can choose an index i and reduce nums[i] by k.

Return an integer denoting the minimum value of k such that nonPositive(nums, k) <= k2.

Example 1:
Input: nums = [3,7,5]
Output: 3
Explanation:
When k = 3, nonPositive(nums, k) = 6 <= k2.
Reduce nums[0] = 3 one time. nums[0] becomes 3 - 3 = 0.
Reduce nums[1] = 7 three times. nums[1] becomes 7 - 3 - 3 - 3 = -2.
Reduce nums[2] = 5 two times. nums[2] becomes 5 - 3 - 3 = -1.

Example 2:
Input: nums = [1]
Output: 1
Explanation:
When k = 1, nonPositive(nums, k) = 1 <= k2.
Reduce nums[0] = 1 one time. nums[0] becomes 1 - 1 = 0.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
 */

package com.contest;

public class MinimumKToReduceArrayWithInLimit_02 {
    public static void main(String[] args) {
        int[] nums = {3,7,5};

        System.out.println(minimumK(nums));
    }

    static int minimumK(int[] nums) {
        int start = 1, e = 100000, ans = 0;
        while (start <= e) {
            int m = start + (e - start) / 2;

            if (nonPositive(nums, m)) {
                ans = m;
                e = m - 1;
            } else {
                start = m + 1;
            }
        }
        return ans;
    }

    static boolean nonPositive(int[] nums, int k) {
        int count = 0;
        long limit = (long) k * k;
        for (int num : nums) {
            count += (num + k - 1) / k;
        }
        return count <= limit;
    }
}
