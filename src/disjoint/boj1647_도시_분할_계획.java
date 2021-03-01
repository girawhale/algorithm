package disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1647_도시_분할_계획 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = inputToIntArray(br.readLine());
        int N = input[0], M = input[1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < M; i++)
            queue.add(inputToIntArray(br.readLine()));

        int cnt = 0, ans = 0;

        while (cnt < N - 2) {
            int[] cur = queue.poll();
            if (find(cur[0]) == find(cur[1])) continue;

            union(cur[0], cur[1]);
            cnt++;
            ans += cur[2];
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

    static int[] inputToIntArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
