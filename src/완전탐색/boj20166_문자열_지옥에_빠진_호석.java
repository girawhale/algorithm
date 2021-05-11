package 완전탐색;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj20166_문자열_지옥에_빠진_호석 {
    static int N, M, K;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Map<String, Integer> countMap;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new char[N][];
        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        countMap = new HashMap<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                dfs(y, x, "");
            }
        }

        while (K-- > 0) {
            System.out.println(countMap.getOrDefault(sc.next(), 0));
        }
    }

    static void dfs(int y, int x, String s) {
        s += map[y][x];
        countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        if (s.length() == 5) return;

        for (int k = 0; k < 8; k++) {
            int ny = (y + dy[k] + N) % N;
            int nx = (x + dx[k] + M) % M;

            dfs(ny, nx, s);
        }
    }
}
