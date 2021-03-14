package BFS;

import java.util.*;

public class boj5213_과외맨 {
    public static void main(String[] args) {
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0, size = N * N - N / 2;
        int[][] nums = new int[N][2 * N], tiles = new int[N][2 * N];

        for (int i = 0; i < N; i++) {
            int tmp = i % 2;
            for (int j = tmp; j < 2 * N - tmp; j++) {
                nums[i][j] = sc.nextInt();
                tiles[i][j] = (cnt++ / 2) + 1;
            }
        }

        ArrayList<Integer>[] adj = new ArrayList[N * N + 1];
        for (int i = 1; i <= N * N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (nums[i][j] == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k], nx = j + dx[k];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= 2 * N ||
                            tiles[ny][nx] == tiles[i][j] || nums[ny][nx] != nums[i][j])
                        continue;

                    adj[tiles[i][j]].add(tiles[ny][nx]);
                }
            }
        }

        int[] visit = new int[size + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = -1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == size) break;

            for (int a : adj[cur]) {
                if (visit[a] != 0) continue;

                queue.add(a);
                visit[a] = cur;
            }
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int n = size;
        while (visit[n] == 0) n--;

        stack.push(n);
        while (visit[stack.peek()] != -1)
            stack.push(visit[stack.peek()]);

        System.out.println(stack.size());
        stack.forEach(i -> System.out.print(i + " "));
    }
}
