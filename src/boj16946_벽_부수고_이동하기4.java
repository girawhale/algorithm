import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16946_벽_부수고_이동하기4 {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int N, M;
    static int[][] map, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        memo = new int[N][M];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().chars().map(n -> n - '0').toArray();

        int cnt = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0 && memo[i][j] == 0)
                    countMap.put(++cnt, dfs(i, j, cnt));

        StringBuilder sb = new StringBuilder();
        List<Integer> ck = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) sb.append(0);
                else {
                    int ret = 1;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k], nx = j + dx[k];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= M || ck.contains(memo[ny][nx]))
                            continue;
                        ck.add(memo[ny][nx]);
                        ret += countMap.getOrDefault(memo[ny][nx], 0);
                    }
                    ck.clear();
                    sb.append(ret % 10);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static int dfs(int y, int x, int n) {
        memo[y][x] = n;

        int cnt = 1;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k], nx = x + dx[k];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || memo[ny][nx] != 0 || map[ny][nx] == 1) continue;

            cnt += dfs(ny, nx, n);
        }

        return cnt;
    }
}
