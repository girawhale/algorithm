package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class boj20007_떡_돌리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = nextInt(st);
        int M = nextInt(st);
        int X = nextInt(st);
        int Y = nextInt(st);

        List<int[]>[] adj = new ArrayList[N];
        IntStream.range(0, N).forEach(i -> adj[i] = new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = nextInt(st);
            int n2 = nextInt(st);
            int d = nextInt(st);

            adj[n1].add(new int[]{n2, d});
            adj[n2].add(new int[]{n1, d});
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        queue.add(new int[]{Y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (dist[cur[0]] <= cur[1]) continue;

            dist[cur[0]] = cur[1];

            for (int[] a : adj[cur[0]]) {
                if (dist[a[0]] <= a[1] + cur[1]) continue;

                queue.add(new int[]{a[0], a[1] + cur[1]});
            }
        }

        Arrays.sort(dist);

        int idx = 0;
        int day = 0;

        while (idx < N) {
            int sum = 0;
            while (idx < N && sum + dist[idx] * 2 <= X) {
                sum += dist[idx++] * 2;
            }

            if (sum == 0) {
                System.out.println(-1);
                return;
            }

            day++;
        }

        System.out.println(day);
    }

    static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
