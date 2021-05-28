package disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj2887_행성_터널 { // dbb1844
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        parent = IntStream.range(0, N).toArray();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        IntStream.rangeClosed(1, 3).forEach(i -> {
            Arrays.sort(arr, Comparator.comparingInt(o -> o[i]));
            for (int j = 1; j < N; j++) {
                queue.add(new int[]{arr[j - 1][0], arr[j][0], Math.abs(arr[j - 1][i] - arr[j][i])});
            }
        });

        int cnt = 0, ans = 0;
        while (!queue.isEmpty() && cnt < N - 1) {
            int[] cur = queue.poll();

            if (find(cur[0]) == find(cur[1])) continue;
            union(cur[0], cur[1]);
            ans += cur[2];

            cnt++;
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
