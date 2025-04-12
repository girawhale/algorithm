package 투포인터;

public class leetcode26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int idx = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] < nums[i]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
