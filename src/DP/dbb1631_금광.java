package DP;

import java.util.Scanner;
import java.util.stream.IntStream;

public class dbb1631_금광 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            int N = sc.nextInt(), M = sc.nextInt();
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    arr[i][j] = sc.nextInt();

            for (int j = 1; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    int max = 0;

                    if (i != 0) max = Math.max(max, arr[i - 1][j - 1]);
                    max = Math.max(max, arr[i][j - 1]);
                    if (i != N - 1) max = Math.max(max, arr[i + 1][j - 1]);

                    arr[i][j] += max;
                }
            }

            System.out.println(IntStream.range(0, N).map(i -> arr[i][M - 1]).max().getAsInt());
        }
    }
}
