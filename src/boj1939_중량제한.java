import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1939_중량제한 {
    static int N, M, start, dest;
    static ArrayList<int[]>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st);
        M = parseInt(st);

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = parseInt(st), n2 = parseInt(st), c = parseInt(st);

            adj[n1].add(new int[]{n2, c});
            adj[n2].add(new int[]{n1, c});
        }
        st = new StringTokenizer(br.readLine());
        start = parseInt(st);
        dest = parseInt(st);

        int s = 1, e = (int) 1e9;
        int ans = 0;
        while (s <= e) {
            int m = (s + e) / 2;

            if (solve(m)) {
                ans = m;
                s = m + 1;
            } else e = m - 1;
        }

        System.out.println(ans);
    }

    static boolean solve(int m) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
            if (cur == dest) return true;

            for (int[] a : adj[cur]) {
                if (a[1] < m || visit[a[0]]) continue;

                visit[a[0]] = true;
                queue.add(a[0]);
            }
        }
        return false;
    }

    static int parseInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }


}
