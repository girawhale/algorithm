package 투포인터;

public class leetcode27_remove_element {
    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        nums[j] = val;
                        break;
                    }
                }
            }

            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }

    public int removeElement_2(int[] nums, int val) {
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ret++] = nums[i];
            }
        }
        return ret;
    }
}
