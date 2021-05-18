package BFS;

import java.util.*;
import java.util.stream.IntStream;

public class boj11967_불켜기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        int N = sc.nextInt(), M = sc.nextInt();
        List<int[]>[][] adj = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                adj[i][j] = new ArrayList<>();

        while (M-- > 0) {
            adj[(sc.nextInt() - 1)][sc.nextInt() - 1].add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1});
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] on = new boolean[N][N];
        boolean[][] visit = new boolean[N][N];

        queue.add(new int[]{0, 0});
        on[0][0] = visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            adj[cur[0]][cur[1]].forEach(e -> {
                on[e[0]][e[1]] = true;

                if (!visit[e[0]][e[1]]) {
                    for (int k = 0; k < 4; k++) {
                        int ny = e[0] + dy[k], nx = e[1] + dx[k];

                        if (ny < 0 || nx < 0 || ny >= N || nx >= N || !visit[ny][nx]) continue;

                        queue.add(e);
                        visit[e[0]][e[1]] = true;
                        break;
                    }
                }
            });
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k], nx = cur[1] + dx[k];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N || !on[ny][nx] || visit[ny][nx]) continue;

                queue.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }

        System.out.println(IntStream.range(0, N).mapToLong(i -> IntStream.range(0, N).filter(j -> on[i][j]).count()).sum());
    }

}