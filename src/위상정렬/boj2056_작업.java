package 위상정렬;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2056_작업 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] time = new int[N + 1];
        int[] inDegree = new int[N + 1];

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();

            int m = sc.nextInt();
            while (m-- > 0) {
                int n = sc.nextInt();
                adj[n].add(i);
                inDegree[i]++;
            }
        }

        int[] end = time.clone();
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans = Math.max(ans, end[cur]);

            for (int a : adj[cur]) {
                end[a] = Math.max(end[cur] + time[a], end[a]);
                if (--inDegree[a] == 0) queue.add(a);
            }
        }

        System.out.println(ans);
    }
}
