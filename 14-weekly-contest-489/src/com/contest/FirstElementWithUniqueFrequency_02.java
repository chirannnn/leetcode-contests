package com.contest;

import java.util.HashMap;
import java.util.Map;

public class FirstElementWithUniqueFrequency_02 {
    public static void main(String[] args) {
        int[] nums = {20,10,30,30};
        System.out.println(firstUniqueFreq(nums));
    }

    static int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : map.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        for (int num : nums) {
            if (freq.get(map.get(num)) == 1) {
                return num;
            }
        }
        return -1;
    }
}
