package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj15812_침략자_진아 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        int town = 0;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.next();

            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';

                if (map[i][j] == 1) town++;
            }
        }

        int ans = Integer.MAX_VALUE;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < N * M; i++) {
            if (map[i / M][i % M] == 1) continue;

            for (int j = i + 1; j < N * M; j++) {
                if (map[j / M][j % M] == 1) continue;

                int day = 0, count = 0;
                Queue<int[]> queue = new LinkedList<>();
                boolean[][] visit = new boolean[N][M];

                queue.add(new int[]{i / M, i % M});
                queue.add(new int[]{j / M, j % M});
                visit[i / M][i % M] = visit[j / M][j % M] = true;

                while (!queue.isEmpty()) {
                    int size = queue.size();

                    while (size-- > 0) {
                        int[] cur = queue.poll();

                        if (map[cur[0]][cur[1]] == 1) count++;

                        for (int k = 0; k < 4; k++) {
                            int ny = cur[0] + dy[k];
                            int nx = cur[1] + dx[k];

                            if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;

                            visit[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                    if (count == town) break;
                    day++;
                }

                ans = Math.min(ans, day);
            }
        }

        System.out.println(ans);
    }
}
