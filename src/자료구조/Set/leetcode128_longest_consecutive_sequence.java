package 자료구조.Set;

import java.util.*;

public class leetcode128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        int res = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 0;
            while (set.contains(num++)) {
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}