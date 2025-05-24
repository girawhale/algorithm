package 자료구조.Map;

import java.util.*;

public class leetcode219_contains_duplicate_ii {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int idx = map.get(nums[i]);
                if (i - idx <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}