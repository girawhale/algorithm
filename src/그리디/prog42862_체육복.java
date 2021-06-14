package 그리디;

import java.util.Arrays;

public class prog42862_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] clothes = new boolean[n + 2];
        boolean[] check = new boolean[n + 2];
        Arrays.fill(clothes, true);

        clothes[0] = false;
        clothes[n + 1] = false;
        for (int l : lost) clothes[l] = false;
        for (int r : reserve) {
            if (!clothes[r]) clothes[r] = true;
            else check[r] = true;
        }

        int ans = 0;
        int[] rent = {0, -1, 1};
        for (int i = 1; i <= n; i++) {
            if (clothes[i]) {
                ans++;
            } else {
                for (int r : rent) {
                    int tmp = i + r;
                    if (check[tmp]) {
                        check[tmp] = false;
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
