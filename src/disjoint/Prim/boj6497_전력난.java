package disjoint.Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj6497_전력난 { // dbb1843_어두운_길
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0) return;

            List<int[]>[] adj = new ArrayList[N];
            for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

            int total = 0;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                adj[x].add(new int[]{y, z});
                adj[y].add(new int[]{x, z});
                total += z;
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            boolean[] visit = new boolean[N];

            visit[0] = true;
            queue.addAll(adj[0]);

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (visit[cur[0]]) continue;
                visit[cur[0]] = true;

                total -= cur[1];
                adj[cur[0]].forEach(o -> {
                    if (!visit[o[0]]) {
                        queue.add(o);
                    }
                });
            }

            System.out.println(total);
        }
    }
}
