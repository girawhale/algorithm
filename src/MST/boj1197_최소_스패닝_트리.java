package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1197_최소_스패닝_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = inputToIntArray(br.readLine());
        int V = input[0], E = input[1];
        ArrayList<int[]>[] adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            input = inputToIntArray(br.readLine());
            adj[input[0]].add(new int[]{input[1], input[2]});
            adj[input[1]].add(new int[]{input[0], input[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{1, 0});
        boolean[] visit = new boolean[V + 1];

        int ans = 0, cnt = 0;
        while (!queue.isEmpty() && cnt < V) {
            int[] cur = queue.poll();

            if (visit[cur[0]]) continue;
            visit[cur[0]] = true;
            ans += cur[1];
            cnt++;

            for (int[] a : adj[cur[0]])
                queue.add(a);
        }
        System.out.println(ans);
    }

    static int[] inputToIntArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
