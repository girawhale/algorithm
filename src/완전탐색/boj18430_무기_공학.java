package 완전탐색;

import java.util.Scanner;

public class boj18430_무기_공학 {
    static int ans, N, M;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int n, int sum) {
        ans = Math.max(ans, sum);
        if (n == N * M) return;

        int y = n / M, x = n % M;
        if (!visit[y][x]) {
            visit[y][x] = true;
            if (y > 0) {
                if (x > 0 && !visit[y - 1][x] && !visit[y][x - 1]) {
                    visit[y - 1][x] = visit[y][x - 1] = true;
                    solve(n + 1, sum + map[y][x] * 2 + map[y - 1][x] + map[y][x - 1]);
                    visit[y - 1][x] = visit[y][x - 1] = false;
                }
                if (x < M - 1 && !visit[y - 1][x] && !visit[y][x + 1]) {
                    visit[y - 1][x] = visit[y][x + 1] = true;
                    solve(n + 1, sum + map[y][x] * 2 + map[y - 1][x] + map[y][x + 1]);
                    visit[y - 1][x] = visit[y][x + 1] = false;
                }
            }
            if (y < N - 1) {
                if (x > 0 && !visit[y + 1][x] && !visit[y][x - 1]) {
                    visit[y + 1][x] = visit[y][x - 1] = true;
                    solve(n + 1, sum + map[y][x] * 2 + map[y + 1][x] + map[y][x - 1]);
                    visit[y + 1][x] = visit[y][x - 1] = false;
                }
                if (x < M - 1 && !visit[y + 1][x] && !visit[y][x + 1]) {
                    visit[y + 1][x] = visit[y][x + 1] = true;
                    solve(n + 1, sum + map[y][x] * 2 + map[y + 1][x] + map[y][x + 1]);
                    visit[y + 1][x] = visit[y][x + 1] = false;
                }
            }
            visit[y][x] = false;
        }
        solve(n + 1, sum);
    }
}
