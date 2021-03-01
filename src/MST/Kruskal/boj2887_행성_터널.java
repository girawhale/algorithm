package MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class boj2887_행성_터널 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = IntStream.range(0, N).toArray();
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[2]));

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        for (int i = 1; i <= 3; i++) {
            int idx = i;
            list.sort(Comparator.comparing(o -> o[idx]));
            for (int j = 0; j < N - 1; j++)
                queue.add(new int[]{list.get(j)[0], list.get(j + 1)[0], Math.abs(list.get(j)[idx] - list.get(j + 1)[idx])});
        }

        long ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (find(cur[0]) != find(cur[1])) {
                union(cur[0], cur[1]);
                ans += cur[2];
            }
        }

        System.out.println(ans);
    }

    static int find(int n) {
        return parent[n] = parent[n] == n ? n : find(parent[n]);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        if (p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
}