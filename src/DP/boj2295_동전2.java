package DP;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj2295_동전2 { // dbb0805
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();
        int[] dp = new int[K + 1];
        Arrays.fill(dp, 1_000_000);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println(dp[K] == 1_000_000 ? -1 : dp[K]);
    }
}
