package 구현.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj17143_낚시왕 {
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dir = {0, 2, 1, 4, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] map = new int[R + 1][C + 1][];
        int[] mod = {0, 2 * R - 2, 2 * C - 2};

        for (int i = 0; i < M; i++) {
            int[] shark = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            shark[2] %= mod[(shark[3] + 1) / 2];
            map[shark[0]][shark[1]] = shark;
        }

        int pos = 0;
        int ans = 0;

        while (pos < C) {
            pos++;

            int y = 1;
            while (y <= R && map[y][pos] == null) y++;
            if (y <= R && map[y][pos] != null) {
                ans += map[y][pos][4];
                map[y][pos] = null;
            }

            Queue<int[]> move = new LinkedList<>();
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] == null) continue;

                    int[] shark = map[i][j];
                    for (int k = 0; k < shark[2]; k++) {
                        if (shark[3] == 1 && shark[0] == 1 || shark[3] == 2 && shark[0] == R
                                || shark[3] == 3 && shark[1] == C || shark[3] == 4 && shark[1] == 1) {
                            shark[3] = dir[shark[3]];
                        }

                        shark[0] += dy[shark[3]];
                        shark[1] += dx[shark[3]];
                    }

                    map[i][j] = null;
                    move.add(shark);
                }
            }

            while (!move.isEmpty()) {
                int[] shark = move.poll();

                if (map[shark[0]][shark[1]] != null) {
                    if (map[shark[0]][shark[1]][4] < shark[4])
                        map[shark[0]][shark[1]] = shark;
                } else map[shark[0]][shark[1]] = shark;
            }
        }

        System.out.println(ans);
    }
}
