package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2529_부등호 {
    static long[] nums;
    static String[] op;
    static long max, min = Long.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        op = br.readLine().split(" ");
        nums = new long[N + 1];

        solve(0, new boolean[10]);
        String format = "%0" + (N + 1) + "d";
        System.out.printf(format + '\n', max);
        System.out.printf(format, min);
    }

    static void solve(int idx, boolean[] visit) {
        if (idx > N) {
            long num = Arrays.stream(nums).reduce(0, (s, n) -> s * 10 + n);
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;
            if (idx > 0) {
                if ((op[idx - 1].equals("<") && nums[idx - 1] > i) ||
                        (op[idx - 1].equals(">") && nums[idx - 1] < i)) continue;
            }

            visit[i] = true;
            nums[idx] = i;
            solve(idx + 1, visit);
            visit[i] = false;
        }
    }
}
