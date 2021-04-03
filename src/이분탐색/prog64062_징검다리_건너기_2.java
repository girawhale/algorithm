package 이분탐색;

public class prog64062_징검다리_건너기_2 {
    public int solution(int[] stones, int k) {
        int s = 1, e = (int) (2 * 1e8), ans = 0;

        while (s <= e) {
            int m = (s + e) / 2;
            if (isPossible(stones, k, m)) {
                ans = m;
                s = m + 1;
            } else e = m - 1;
        }

        return ans;
    }

    boolean isPossible(int[] stones, int k, int m) {
        int cnt = 0;
        for (int stone : stones) {
            if (stone < m) cnt++;
            else cnt = 0;

            if (cnt >= k) return false;
        }

        return cnt < k;
    }
}
