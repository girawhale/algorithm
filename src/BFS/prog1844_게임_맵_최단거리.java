package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class prog1844_게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int N = maps.length, M = maps[0].length;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];

                if (ny >= N || ny < 0 || nx >= M || nx < 0 || visit[ny][nx] || maps[ny][nx] == 0) continue;

                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx, cur[2] + 1});
            }
        }

        return -1;
    }
}
