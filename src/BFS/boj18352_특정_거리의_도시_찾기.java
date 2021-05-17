package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class boj18352_특정_거리의_도시_찾기 { // dbb1315

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = nextIntFromToken(st);
        int M = nextIntFromToken(st);
        int K = nextIntFromToken(st);
        int X = nextIntFromToken(st);

        List<Integer>[] adj = new List[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            adj[nextIntFromToken(st)].add(nextIntFromToken(st));
        }

        int[] dist = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        dist[X] = 0;
        visit[X] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (dist[cur] == K) continue;
            for (int a : adj[cur]) {
                if (visit[a]) continue;

                dist[a] = dist[cur] + 1;
                queue.add(a);
                visit[a] = true;
            }
        }
        StringBuilder sb = IntStream.rangeClosed(1, N).filter(i -> dist[i] == K)
                .collect(StringBuilder::new, (s, i) -> s.append(i).append('\n'), StringBuilder::append);

        System.out.println(sb.length() == 0 ? -1 : sb);

    }

    private static int nextIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
