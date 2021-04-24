package 완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj15812_침략자_진아 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        List<int[]> townList = new ArrayList<>();
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();

            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) == '1';

                if (map[i][j]) townList.add(new int[]{i, j});
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N * M - 1; i++) {
            int[] pointI = {i / M, i % M};
            if (map[pointI[0]][pointI[1]]) continue;

            for (int j = i + 1; j < N * M; j++) {
                int[] pointJ = {j / M, j % M};
                if (map[pointJ[0]][pointJ[1]]) continue;

                int max = 0;
                for (int[] town : townList) {
                    max = Math.max(max, Math.min(getDist(town, pointI), getDist(town, pointJ)));
                }
                ans = Math.min(max, ans);
            }

        }

        System.out.println(ans);
    }

    static int getDist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
