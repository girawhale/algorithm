import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj17835_면접보는_승범이네 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        ArrayList<Edge>[] adj = new ArrayList[N + 1];
        long[] dist = new long[N + 1];
        Arrays.fill(dist, -1);

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            adj[n2].add(new Edge(n1, cost));
        }

        PriorityQueue<Edge> que = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost != o2.cost)
                return Long.compare(o1.cost, o2.cost);
            return Integer.compare(o2.to, o1.to);
        });

        input = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(input[i]);
            dist[k] = 0;

            for (int j = 0; j < adj[k].size(); j++) {
                que.add(adj[k].get(j));
            }
        }

        Edge max = null;
        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (dist[cur.to] != -1)
                continue;

            dist[cur.to] = cur.cost;
            max = cur;

            for (int i = 0; i < adj[cur.to].size(); i++) {
                Edge next = adj[cur.to].get(i);

                if (dist[next.to] == -1)
                    que.add(new Edge(next.to, cur.cost + next.cost));
            }
        }

        System.out.println(max.to);
        System.out.println(max.cost);
    }

    static class Edge {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

    }
}
