package 투포인터;

import java.util.*;

public class leetcode15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int right = nums.length - 1;
            int left = i + 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        leetcode15_3sum sol = new leetcode15_3sum();

        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(sol.threeSum(new int[]{0, 1, 1}));
        System.out.println(sol.threeSum(new int[]{0, 0, 0}));
    }
}