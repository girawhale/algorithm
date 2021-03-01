package DFS;

import java.util.Scanner;

public class boj1987_알파벳 {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int R, C, ans;
    static char[][] map;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][];
        visit = new boolean[26];

        for (int i = 0; i < R; i++)
            map[i] = sc.next().toCharArray();

        dfs(0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int y, int x, int cnt) {
        ans = Math.max(cnt, ans);
        visit[map[y][x] - 'A'] = true;

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k], nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[map[ny][nx] - 'A']) continue;

            dfs(ny, nx, cnt + 1);
        }

        visit[map[y][x] - 'A'] = false;
    }
}
