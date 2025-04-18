package 그리디;

import java.util.*;

public class leetcode45_jump_game_ii {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] counts = new int[len];
        Arrays.fill(counts, 987654321);

        counts[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i] && i + j < len; j++) {
                counts[i + j] = Math.min(counts[i + j], counts[i] + 1);
            }
        }

        return counts[len - 1];
    }

    public int jump2(int[] nums) {
        int jumpCount = 0;
        int max = 0;
        int currEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == currEnd) {
                jumpCount++;
                currEnd = max;
            }
        }

        return jumpCount;
    }
}