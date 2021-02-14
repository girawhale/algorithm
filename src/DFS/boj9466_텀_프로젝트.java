package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj9466_텀_프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int ans = N;
            int[] group = new int[N], cnt = new int[N];
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(i -> Integer.parseInt(i) - 1).toArray();

            for (int i = 0; i < N; i++) {
                int cur = i, idx = 0;

                while (group[cur] == 0) {
                    group[cur] = i + 1;
                    cnt[cur] = ++idx;

                    cur = arr[cur];
                }

                if (group[cur] != i + 1) continue;
                ans -= (idx - cnt[cur] + 1);
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb.toString());
    }
}
