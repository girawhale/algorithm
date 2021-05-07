package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14391_종이_조각 {
    static int[][] arr;
    static int N, M, ans;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine().chars().map(j -> j - '0').toArray();


        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int n, int sum) {
        if (n == N * M) {
            ans = Math.max(ans, sum);
            return;
        }
        int y = n / M;
        int x = n % M;
        if (visit[y][x])
            solve(n + 1, sum);

        int num = 0;
        for (int nx = x; nx < M; nx++) {
            if (visit[y][nx]) break;
            for (int i = x; i <= nx; i++) visit[y][i] = true;
            num = num * 10 + arr[y][nx];

            visit[y][nx] = true;
            solve(y * M + nx + 1, num + sum);
            for (int i = x; i <= nx; i++) visit[y][i] = false;
        }

        num = 0;
        for (int ny = y; ny < N; ny++) {
            if (visit[ny][x]) break;
            for (int i = y; i <= ny; i++) visit[i][x] = true;
            num = num * 10 + arr[ny][x];

            visit[ny][x] = true;
            solve(y * M + x + 1, num + sum);
            for (int i = y; i <= ny; i++) visit[i][x] = false;
        }

    }
}
