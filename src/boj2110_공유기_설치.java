import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110_공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] home = new int[N];
        for (int i = 0; i < N; i++) home[i] = Integer.parseInt(br.readLine());
        Arrays.sort(home);

        int s = 0, e = (int) 1e9, ans = 0;

        while (s <= e) {
            int m = (s + e) / 2;
            int prev = home[0];
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (home[i] - prev >= m) {
                    cnt++;
                    prev = home[i];
                }
            }

            if (cnt >= C) {
                ans = m;
                s = m + 1;
            } else e = m - 1;
        }

        System.out.println(ans);
    }
}
