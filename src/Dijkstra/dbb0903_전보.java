package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dbb0903_전보 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = nextInt(st);
        int M = nextInt(st);
        int C = nextInt(st);

        List<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            adj[nextInt(st)].add(new int[]{nextInt(st), nextInt(st)});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new int[]{C, 0});

        int cnt = -1, time = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dist[cur[0]] < cur[1]) continue;
            cnt++;
            time = cur[1];

            adj[cur[0]].forEach(o -> {
                if (dist[o[0]] >= o[1] + cur[1]) {
                    pq.add(new int[]{o[0], o[1] + cur[1]});
                    dist[o[0]] = o[1] + cur[1];
                }
            });
        }

        System.out.println(cnt + " " + time);
    }

    private static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
