/*
You are given an integer array nums.

In one operation, you remove the first three elements of the current array. If there are fewer than three elements remaining, all remaining elements are removed.

Repeat this operation until the array is empty or contains no duplicate values.

Return an integer denoting the number of operations required.

Example 1:
Input: nums = [3,8,3,6,5,8]
Output: 1
Explanation:
In the first operation, we remove the first three elements. The remaining elements [6, 5, 8] are all distinct, so we stop. Only one operation is needed.

Example 2:
Input: nums = [2,2]
Output: 1
Explanation:
After one operation, the array becomes empty, which meets the stopping condition.

Example 3:
Input: nums = [4,3,5,1,2]
Output: 0
Explanation:
All elements in the array are distinct, therefore no operations are needed.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
 */

package com.contest;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperationstoHaveDistinctElements_01 {
    public static void main(String[] args) {
        int[] nums = {4,3,5,1,2};

        System.out.println(minOperations(nums));
    }

    /*
Approach:
- We want the array to have all distinct elements.
- One operation removes the first 3 elements (or all if < 3).
- Instead of simulating removals, we observe from the BACK.

Idea:
- Traverse from right to left and store seen elements in a HashSet.
- If we see a duplicate, then this index must be removed.
- That means we must remove elements from index 0 to i.
- Since each operation removes 3 elements from the front,
  number of operations = ceil((i + 1) / 3).
*/

    static int minOperations(int[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (st.contains(nums[i])) {
                int len = i + 1;
                return (len / 3) + (len % 3 == 0 ? 0 : 1);
            }
            st.add(nums[i]);
        }
        return 0;
    }
}
