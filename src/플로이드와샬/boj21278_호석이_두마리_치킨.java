package 플로이드와샬;

import java.util.Arrays;
import java.util.Scanner;

public class boj21278_호석이_두마리_치킨 {
    public static void main(String[] args) {
        final int INF = 1_000_000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (M-- > 0) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            dist[n1][n2] = dist[n2][n1] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }

        int[] ans = {0, 0, INF};

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int sum = 0;
                for (int k = 1; k <= N; k++)
                    sum += Math.min(dist[k][i], dist[k][j]) * 2;

                if (sum < ans[2])
                    ans = new int[]{i, j, sum};
            }
        }


        Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
    }
}
