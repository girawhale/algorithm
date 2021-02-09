package BFS;

import java.util.*;

public class boj12852_1로_만들기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] visit = new int[1_000_001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == X) break;

            int[] next = {num + 1, num * 2, num * 3};
            for (int n : next) {
                if (n > 1_000_000 || visit[n] != 0) continue;
                queue.add(n);
                visit[n] = num;
            }
        }

        List<Integer> trace = new LinkedList<>();
        int n = X;
        trace.add(n);

        while (n != 1) {
            n = visit[n];
            trace.add(n);
        }

        System.out.println(trace.size() - 1);
        trace.stream().forEach(i -> System.out.print(i + " "));
    }
}
