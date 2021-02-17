package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1981_배열에서_이동 {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 200, s = 0, e = 0;
        while (s <= 200 && e <= 200) {
            if (bfs(s, e)) {
                ans = Math.min(ans, e - s);
                s++;
            } else e++;
        }
        System.out.println(ans);
    }

    static boolean bfs(int s, int e) {
        if (map[0][0] < s || map[0][0] > e) return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        queue.add(new int[]{0, 0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == n - 1 && cur[1] == n - 1) return true;

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx]
                        || s > map[ny][nx] || e < map[ny][nx])
                    continue;

                queue.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
        return false;
    }
}
