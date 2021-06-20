package 플로이드와샬;

import java.util.Scanner;
import java.util.stream.IntStream;

public class boj10159_저울 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] dist = new boolean[N + 1][N + 1];

        while (M-- > 0) dist[sc.nextInt()][sc.nextInt()] = true;

        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i][k] && dist[k][j])
                        dist[i][j] = true;

        IntStream.rangeClosed(1, N).forEach(i ->
                System.out.println(N - 1 - IntStream.rangeClosed(1, N)
                        .filter(j -> dist[i][j] || dist[j][i]).count()));
    }
}
