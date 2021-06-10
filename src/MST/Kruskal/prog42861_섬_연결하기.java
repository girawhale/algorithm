package MST.Kruskal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class prog42861_섬_연결하기 {
    int[] parent;

    public int solution(int n, int[][] costs) {
        int ans = 0;
        parent = IntStream.range(0, n).toArray();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.addAll(Arrays.asList(costs));

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (union(cur[0], cur[1])) {
                ans += cur[2];
            }
        }

        return ans;
    }

    int find(int n) {
        return parent[n] = parent[n] == n ? n : find(parent[n]);
    }

    boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        if (p1 == p2)
            return false;

        if (p1 < p2) parent[p2] = p1;
        else parent[p2] = p1;
        return true;
    }

    public static void main(String[] args) {
        new prog42861_섬_연결하기().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});
    }
}
