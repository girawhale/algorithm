package 다시보기.플로이드와샬;

import java.util.Arrays;
import java.util.stream.IntStream;

public class prog49191_순위 {
    public int solution(int n, int[][] results) {
        boolean[][] adj = new boolean[n + 1][n + 1];

        for (int[] ret : results)
            adj[ret[0]][ret[1]] = true;

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (adj[i][k] & adj[k][j])
                        adj[i][j] = adj[i][k] & adj[k][j];

        for (boolean[] b : adj)
            System.out.print(Arrays.toString(b));


        return (int) IntStream.rangeClosed(1, n)
                .filter(i -> IntStream.rangeClosed(1, n)
                        .filter(j -> adj[i][j] || adj[j][j])
                        .count() == n - 1)
                .count();
    }
}
