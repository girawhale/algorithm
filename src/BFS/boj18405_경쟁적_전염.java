package BFS;

import java.util.*;

public class boj18405_경쟁적_전염 { // dbb1317
    public static void main(String[] args) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        int[][] map = new int[N][N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0)
                    pq.add(new int[]{i, j, map[i][j]});
            }
        }
        int S = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt();

        Queue<int[]> queue = new LinkedList<>();
        while (!pq.isEmpty())
            queue.add(pq.poll());

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (time == S) break;
            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != 0) continue;
                    map[ny][nx] = map[cur[0]][cur[1]];
                    queue.add(new int[]{ny, nx});
                }
            }
            time++;
        }

        System.out.println(map[X - 1][Y - 1]);

    }
}
