package 플로이드와샬;

import java.util.Arrays;
import java.util.stream.IntStream;

public class prog12978_배달 {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 5000000);
            dist[i][i] = 0;
        }

        for (int[] r : road) {
            dist[r[0]][r[1]] = dist[r[1]][r[0]] = Math.min(dist[r[0]][r[1]], r[2]);
        }

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return (int) IntStream.rangeClosed(1, N)
                .filter(i -> dist[1][i] <= K)
                .count();
    }
}
