import java.util.*;

public class boj21608_상어_초등학교 {
    static int N;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int[] score = {0, 1, 10, 100, 1000};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int[][] map = new int[N][N];
        Set<Integer>[] prefer = new HashSet[N * N + 1];
        for (int i = 0; i < N * N; i++)
            prefer[i + 1] = new HashSet<>();


        for (int t = 0; t < N * N; t++) {
            int n = sc.nextInt();
            for (int j = 0; j < 4; j++)
                prefer[n].add(sc.nextInt());

            int[] point = null;
            int[] count = {0, 0};
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) continue;

                    int[] tmp = getCount(prefer[n], i, j, map);
                    if (tmp[0] > count[0] || (tmp[0] == count[0] && tmp[1] > count[1]) || point == null) {
                        point = new int[]{i, j};
                        count = tmp;
                    }
                }
            }
            map[point[0]][point[1]] = n;
        }

        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ans += score[getCount(prefer[map[i][j]], i, j, map)[0]];

        System.out.println(ans);
    }

    static int[] getCount(Set<Integer> set, int y, int x, int[][] map) {
        int[] ret = {0, 0};

        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;

            if (set.contains(map[ny][nx])) ret[0]++;
            if (map[ny][nx] == 0) ret[1]++;
        }
        return ret;
    }
}
