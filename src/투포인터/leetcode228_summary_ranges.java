package 투포인터;

import java.util.*;

public class leetcode228_summary_ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j - 1] + 1 == nums[j]) {
                j++;
            }
            res.add((i + 1) == j ? String.valueOf(nums[i]) : (nums[i] + "->" + (nums[j - 1])));
            i = j;
        }

        return res;
    }
}