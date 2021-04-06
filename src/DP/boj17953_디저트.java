package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj17953_디저트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dessert = new int[M][N];
        for (int i = 0; i < M; i++)
            dessert[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] ret = new int[M][N];
        for (int i = 0; i < M; i++)
            ret[i][0] = dessert[i][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    if (j == k)
                        ret[j][i] = Math.max(ret[j][i], dessert[j][i] / 2 + ret[k][i - 1]);
                    else
                        ret[j][i] = Math.max(ret[j][i], dessert[j][i] + ret[k][i - 1]);
                }
            }
        }

        System.out.println(IntStream.range(0, M).map(i -> ret[i][N - 1]).max().getAsInt());
    }
}
