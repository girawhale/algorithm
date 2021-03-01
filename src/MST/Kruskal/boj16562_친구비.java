package MST.Kruskal;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj16562_친구비 {
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();

        parents = IntStream.range(0, N + 1).toArray();

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 1; i <= N; i++) queue.add(new int[]{i, sc.nextInt()});

        for (int i = 0; i < M; i++)
            union(sc.nextInt(), sc.nextInt());

        int money = 0;
        boolean[] visit = new boolean[N + 1];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visit[find(cur[0])]) continue;

            money += cur[1];
            if (money > K) {
                System.out.println("Oh no");
                return;
            }

            visit[find(cur[0])] = true;
        }
        System.out.println(money);

    }

    static int find(int n) {
        return parents[n] = n == parents[n] ? n : find(parents[n]);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 < p2) parents[p2] = p1;
        else parents[p1] = p2;
    }
}
