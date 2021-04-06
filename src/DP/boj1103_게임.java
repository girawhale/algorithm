package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1103_게임 {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static boolean[][] visit;
    static char[][] map;
    static int[][] dp;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][];
        visit = new boolean[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dp[i], -1);
        }

        dfs(0, 0);

        System.out.println(dp[0][0]);
    }

    static int dfs(int y, int x) {
        if (dp[y][x] != -1) return dp[y][x];

        visit[y][x] = true;
        int n = map[y][x] - '0';
        int ret = 1;

        for (int k = 0; k < 4; k++) {
            int ny = y + n * dy[k];
            int nx = x + n * dx[k];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 'H') continue;
            if (visit[ny][nx]) {
                System.out.println(-1);
                System.exit(0);
            }

            ret = Math.max(ret, dfs(ny, nx) + 1);
        }

        visit[y][x] = false;
        return dp[y][x] = ret;
    }

}
