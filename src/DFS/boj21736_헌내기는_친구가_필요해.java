package DFS;

import java.util.*;

public class boj21736_헌내기는_친구가_필요해 {
    static int N, M;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][];
        int ret = 0;

        for (int i = 0; i < N; i++) map[i] = sc.next().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    ret = dfs(i, j, new boolean[N][M]);
                }
            }
        }
        System.out.println(ret == 0 ? "TT" : ret);
    }

    static int dfs(int x, int y, boolean[][] history) {
        if (x < 0 || y < 0 || x >= N || y >= M || history[x][y] || map[x][y] == 'X') return 0;
        history[x][y] = true;

        int ret = 0;
        if (map[x][y] == 'P') ret++;

        for (int i = 0; i < 4; i++) {
            ret += dfs(x + dx[i], y + dy[i], history);
        }
        return ret;
    }
}
