package MST;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj4386_별자리_만들기 {
    static class Edge implements Comparable<Edge> {
        int n;
        double dist;

        public Edge(int n, double dist) {
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double[][] star = new double[N][];

        for (int i = 0; i < N; i++)
            star[i] = new double[]{sc.nextDouble(), sc.nextDouble()};

        List<Edge>[] edges = new ArrayList[N + 1];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                double d1 = star[i][0] - star[j][0];
                double d2 = star[i][1] - star[j][1];
                edges[i].add(new Edge(j, Math.sqrt(d1 * d1 + d2 * d2)));
            }
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[N];

        queue.add(new Edge(0, 0));
        double ans = 0;
        int cnt = 0;

        while (cnt < N) {
            Edge edge = queue.poll();

            if (visit[edge.n]) continue;
            visit[edge.n] = true;
            cnt++;
            ans += edge.dist;

            queue.addAll(edges[edge.n]);
        }

        System.out.printf("%.2f",ans);
    }
}
