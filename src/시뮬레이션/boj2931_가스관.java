package 시뮬레이션;

import java.util.Scanner;

public class boj2931_가스관 {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1}; //상, 하, 좌, 우
    static char[][] map;
    static boolean[][] visit;
    static int R, C;
    static char[] pipe = {'+', '1', '2', '3', '4', '|', '-'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        visit = new boolean[R][C];

        int[] start = null;
        for (int i = 0; i < R; i++) {
            char[] in = sc.next().toCharArray();

            for (int j = 0; j < C; j++) {
                if (in[j] == 'M') start = new int[]{i, j};
                map[i][j] = in[j];
            }
        }

        visit[start[0]][start[1]] = true;
        for (int i = 0; i < 4; i++) {
            int ny = start[0] + dy[i], nx = start[1] + dx[i];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '.' || map[ny][nx] == 'Z') continue;
            solve(ny, nx, getNextDir(map[ny][nx], i));
        }

    }

    static void solve(int y, int x, int dir) {
        for (int i = 0; i < 4; i++) {
            if (((1 << i) & dir) == 0) continue;

            int ny = y + dy[i], nx = x + dx[i];
            if (visit[ny][nx]) continue;

            if (map[ny][nx] == '.') {
                for (char p : pipe) {
                    int d = getNextDir(p, i);
                    if (d != 0 && ckSetPipe(ny, nx, d)) {
                        System.out.println((ny + 1) + " " + (nx + 1) + " " + p);
                        System.exit(0);
                    }
                }
            }

            visit[ny][nx] = true;
            solve(ny, nx, getNextDir(map[ny][nx], i));
        }
    }

    static boolean ckSetPipe(int y, int x, int dir) {
        for (int i = 0; i < 4; i++) {
            if (((1 << i) & dir) == 0) continue;

            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= R || nx >= C
                    || map[ny][nx] == '.' || getNextDir(map[ny][nx], i) == 0) return false;
        }
        return true;
    }

    static int getNextDir(char pipe, int in) {
        if (pipe == '+')
            return 1 << 4 - 1;
        else if (pipe == '|') {
            if (in == 0) return 1 << 0;
            else if (in == 1) return 1 << 1;
        } else if (pipe == '-') {
            if (in == 2) return 1 << 2;
            else if (in == 3) return 1 << 3;
        } else if (pipe == '1') {
            if (in == 2) return 1 << 1;
            else if (in == 0) return 1 << 3;
        } else if (pipe == '2') {
            if (in == 1) return 1 << 3;
            else if (in == 2) return 1 << 0;
        } else if (pipe == '3') {
            if (in == 3) return 1 << 0;
            else if (in == 1) return 1 << 2;
        } else if (pipe == '4') {
            if (in == 3) return 1 << 1;
            else if (in == 0) return 1 << 2;
        }
        return 0;
    }
}
