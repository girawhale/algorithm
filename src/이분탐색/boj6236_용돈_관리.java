package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6236_용돈_관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] day = new int[N];
        int s = 0, e = (int) 1e9, ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(br.readLine());
            s = Math.max(s, day[i]);
        }

        while (s <= e) {
            int m = (s + e) / 2;

            int count = 0;
            int money = 0;
            for (int i = 0; i < N; i++) {
                if (money < day[i]) {
                    money = m;
                    count++;
                }
                money -= day[i];
            }
            if (count > M) {
                s = m + 1;
            } else {
                ans = m;
                e = m - 1;
            }
        }
        System.out.println(ans);
    }
}

