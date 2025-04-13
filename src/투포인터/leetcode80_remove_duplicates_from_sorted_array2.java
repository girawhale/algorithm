package 투포인터;

import java.util.Arrays;

public class leetcode80_remove_duplicates_from_sorted_array2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[k] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
