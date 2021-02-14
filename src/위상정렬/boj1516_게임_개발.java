package 위상정렬;

import java.util.*;

public class boj1516_게임_개발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        int[] time = new int[N + 1], start = new int[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();

            int n;
            while ((n = sc.nextInt()) != -1) {
                adj[n].add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int a : adj[cur]) {
                start[a] = Math.max(start[a], start[cur] + time[cur]);

                if (--inDegree[a] == 0)
                    queue.add(a);
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.println(start[i] + time[i]);

    }
}
