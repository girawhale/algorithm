package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4991_로봇_청소기 {
    public static void main(String[] args) {
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        Scanner sc = new Scanner(System.in);
        while (true) {
            int w = sc.nextInt(), h = sc.nextInt();
            if (w == 0) return;

            int[][] map = new int[h][w];
            int[] cleaner = new int[2];
            int dirty = 0;
            for (int i = 0; i < h; i++) {
                String in = sc.next();
                for (int j = 0; j < w; j++) {
                    switch (in.charAt(j)) {
                        case 'x':
                            map[i][j] = -1;
                            break;
                        case '*':
                            map[i][j] = ++dirty;
                            break;
                        case 'o':
                            cleaner = new int[]{i, j};
                    }
                }
            }
            int ans = -1;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][][] visit = new boolean[h][w][1 << (dirty + 1)];
            visit[cleaner[0]][cleaner[1]][1] = true;
            queue.add(new int[]{cleaner[0], cleaner[1], 0, 1});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[3] == (1 << (dirty + 1)) - 1) {
                    ans = cur[2];
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || ny >= h || nx >= w || map[ny][nx] == -1) continue;

                    int b = cur[3] | 1 << map[ny][nx];
                    if (!visit[ny][nx][b]) queue.add(new int[]{ny, nx, cur[2] + 1, b});
                    visit[ny][nx][b] = true;
                }
            }

            System.out.println(ans);
        }
    }
}
