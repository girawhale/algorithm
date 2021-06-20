package 정렬;

import java.util.Arrays;

public class prog12982_예산 {
    public int solution(int[] d, int budget) {
        int ans = 0;
        Arrays.sort(d);
        for (int n : d) {
            if (n > budget) break;
            budget -= n;
            ans++;
        }

        return ans;
    }
}
