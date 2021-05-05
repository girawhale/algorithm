package 다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3151_합이_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long ans = 0;
        int[] cnt = new int[40001];
        for (int i = 0; i < N; i++) {
            ans += cnt[20000 - A[i]];
            for (int j = 0; j < i; j++) {
                cnt[20000 + A[i] + A[j]]++;
            }
        }
        System.out.println(ans);
    }
}
