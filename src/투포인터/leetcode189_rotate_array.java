package 투포인터;

public class leetcode189_rotate_array {
    public void rotate(int[] nums, int k) {
        int count = 0;
        int len = nums.length;

        for (int start = 0; count < len; start++) {
            int idx = start;
            int prev = nums[start];

            do {
                int n = (idx + k) % nums.length;

                int temp = nums[n];
                nums[n] = prev;
                prev = temp;

                idx = n;
                count++;
            } while (idx != start);
        }
    }
}
