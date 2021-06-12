package 이분탐색;

import java.util.Arrays;

public class prog43238_입국심사 {
    public long solution(int n, int[] times) {
        long s = 0, e = (long) 1e14;

        while (s < e) {
            long mid = (s + e) / 2;

            long sum = Arrays.stream(times).mapToLong(t -> t / mid).sum();
            if (sum < n) s = mid + 1;
            else e = mid;
        }

        return e;
    }
}
