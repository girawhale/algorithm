package 플로이드와샬;

import java.util.Scanner;
import java.util.stream.IntStream;

public class dbb1738_정확한_순위 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        boolean[][] adj = new boolean[N + 1][N + 1];

        while (M-- > 0)
            adj[sc.nextInt()][sc.nextInt()] = true;

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (adj[i][k] & adj[k][j])
                        adj[i][j] = adj[i][k] & adj[k][j];

        long count = IntStream.rangeClosed(1, N)
                .filter(i -> IntStream
                        .rangeClosed(1, N)
                        .filter(j -> adj[i][j] | adj[j][i])
                        .count() == N - 1)
                .count();
        System.out.println(count);
    }
}
