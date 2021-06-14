package 완전탐색;

import java.util.Arrays;

public class prog1297_소수_만들기 {
    int ans = 0;
    boolean[] isPrime = new boolean[3000];

    public int solution(int[] nums) {
        Arrays.fill(isPrime, true);
        for (int i = 2; i < Math.sqrt(3000); i++) {
            for (int j = 2; i * j < 3000; j++) {
                isPrime[i * j] = false;
            }
        }

        solve(0, 0, 0, nums);

        return ans;
    }

    public void solve(int idx, int cnt, int sum, int[] nums) {
        if (cnt == 3) {
            if (isPrime[sum]) ans++;
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            solve(i + 1, cnt + 1, sum + nums[i], nums);
        }
    }
}
