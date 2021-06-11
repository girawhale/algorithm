package DFS;

public class prog43162_네트워크 {
    boolean[] visit;

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            ans++;
            dfs(i, n, computers);
        }
        return ans;
    }

    void dfs(int idx, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (computers[idx][i] == 0 || visit[i]) continue;

            visit[i] = true;
            dfs(i, n, computers);
        }
    }
}
