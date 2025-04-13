package 자료구조;

import java.util.*;

public class leetcode169_majority_element {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

}
