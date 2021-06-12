package 다시보기.이분탐색;

import java.util.Arrays;

public class prog43236_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int s = 0, e = (int) 1e9, ans = 0;

        while (s < e) {
            int mid = (s + e) / 2;
            int prev = 0, removeCnt = 0;

            for (int rock : rocks) {
                int diff = rock - prev;
                if (diff < mid) removeCnt++;
                else prev = rock;
            }

            if (distance - prev < mid) removeCnt++;

            if (removeCnt < n) {
                s = mid + 1;
                ans = mid;
            }
            else e = mid;
        }

        return ans;
    }
}
