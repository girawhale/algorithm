package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16397_탈출 {
    public static void main(String[] args) {
        final int INF = 100_000;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int G = sc.nextInt();

        boolean[] visit = new boolean[INF];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == G) {
                    System.out.println(cnt);
                    return;
                }

                if (cur + 1 < INF && !visit[cur + 1]) {
                    queue.add(cur + 1);
                    visit[cur + 1] = true;
                }
                if (cur * 2 < INF) {
                    int next = cur * 2;
                    next -= Math.pow(10, (int) Math.log10(cur*2));
                    if (!visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }

                }
            }
            if (++cnt > T) break;
        }

        System.out.println("ANG");
    }
}
