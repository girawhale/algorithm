package 그리디;

public class leetcode55_jump_game {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] available = new boolean[len];

        available[0] = true;
        for (int i = 0; i < len; i++) {
            if (!available[i]) {
                continue;
            }
            for (int j = 1; j <= nums[i]&& i + j < len; j++) {
                available[i + j] = true;
            }
        }

        return available[len - 1];
    }

    public boolean canJump2(int[] nums) {
        int maxAvailable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxAvailable) {
                return false;
            }
            maxAvailable = Math.max(maxAvailable, nums[i] + i);
        }
        return maxAvailable > nums.length - 1;
    }
}