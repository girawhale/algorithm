package Dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dbb1739_화성_탐사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        int[] dy = new int[]{-1, 1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        while (TC-- > 0) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.add(new int[]{0, 0, map[0][0]});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                if (dist[cur[0]][cur[1]] < cur[2]) continue;
                dist[cur[0]][cur[1]] = cur[2];

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || dist[ny][nx] <= cur[2] + map[ny][nx]) continue;
                    int d = cur[2] + map[ny][nx];

                    pq.add(new int[]{ny, nx, d});
                    dist[ny][nx] = d;
                }
            }

            System.out.println(dist[N - 1][N - 1]);
        }
    }
}
