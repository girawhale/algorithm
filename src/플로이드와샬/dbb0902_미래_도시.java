package 플로이드와샬;

import java.util.Arrays;
import java.util.Scanner;

public class dbb0902_미래_도시 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int INF = 987654321;
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(dist[i], INF);

        while (M-- > 0) {
            int n1 = sc.nextInt(), n2 = sc.nextInt();
            dist[n1][n2] = dist[n2][n1] = 1;
        }
        int X = sc.nextInt(), K = sc.nextInt();

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int d = dist[1][K] + dist[K][X];
        System.out.println(d >= INF ? -1 : d);
    }
}
