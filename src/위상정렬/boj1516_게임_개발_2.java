package 위상정렬;

import java.util.*;
import java.util.stream.IntStream;

public class boj1516_게임_개발_2 { // dbb1004 커리큘럼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] inDegree = new int[N + 1];
        int[] time = new int[N + 1];
        int[] max = new int[N + 1];
        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();

            int in;
            while ((in = sc.nextInt()) != -1) {
                inDegree[i]++;
                adj[in].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            if (inDegree[i] == 0) queue.add(i);


        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int a : adj[cur]) {
                max[a] = Math.max(max[a], max[cur] + time[cur]);
                if (--inDegree[a] == 0)
                    queue.add(a);
            }
        }

        IntStream.rangeClosed(1, N).forEach(i -> System.out.println(time[i] + max[i]));
    }
}
