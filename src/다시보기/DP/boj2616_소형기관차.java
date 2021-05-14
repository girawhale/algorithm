package 다시보기.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2616_소형기관차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] train = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = train[i - 1] + sum[i - 1];
        }

        int[][] dp = new int[4][N + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = M; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + (sum[j] - sum[j - M]));
            }
        }
        System.out.println(dp[3][N]);
    }
}
