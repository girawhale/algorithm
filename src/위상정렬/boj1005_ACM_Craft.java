package 위상정렬;

import java.util.*;

public class boj1005_ACM_Craft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt(), K = sc.nextInt();

            int[] time = new int[N + 1];
            ArrayList<Integer>[] adj = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
                time[i] = sc.nextInt();
            }

            for (int i = 0; i < K; i++) {
                int n1 = sc.nextInt(), n2 = sc.nextInt();
                adj[n1].add(n2);
                inDegree[n2]++;
            }

            Queue<Integer> queue = new LinkedList();
            int[] start = new int[N + 1];
            int n = sc.nextInt();

            for (int i = 1; i <= N; i++)
                if (inDegree[i] == 0) queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int a : adj[cur]) {
                    start[a] = Math.max(start[a], start[cur] + time[cur]);

                    if (--inDegree[a] == 0) {
                        queue.add(a);
                    }
                }
            }

            System.out.println(start[n] + time[n]);
        }
    }
}
