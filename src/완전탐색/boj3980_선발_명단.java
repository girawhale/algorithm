package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3980_선발_명단 {
    static int[][] s;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            s = new int[11][];
            ans = 0;

            for (int i = 0; i < 11; i++) {
                s[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            solve(0, 0, 0);
            System.out.println(ans);
        }
    }

    static void solve(int idx, int visit, int sum) {
        if (idx == 11) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if ((visit & (1 << i)) > 0 || s[idx][i] == 0) continue;
            solve(idx + 1, visit | (1 << i), sum + s[idx][i]);
        }
    }
}
