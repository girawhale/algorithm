package BFS;

import java.util.*;

public class boj12886_돌그룹 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] group = {{0, 1, 2}, {0, 2, 1}, {1, 2, 0}};
        int[] stone = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        if (Arrays.stream(stone).sum() % 3 != 0) {
            System.out.println(0);
            return;
        }

        boolean[][] visit = new boolean[500][1000];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(stone);

        Arrays.sort(stone);
        visit[stone[0]][stone[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if ((cur[0] == cur[1]) && (cur[1] == cur[2])) {
                System.out.println(1);
                return;
            }

            for (int[] g : group) {
                int s1 = cur[g[0]];
                int s2 = cur[g[1]];

                int min = Math.min(s1, s2);
                int max = Math.max(s1, s2);

                int[] next = {max - min, min * 2, cur[g[2]]};
                Arrays.sort(next);

                if (visit[next[0]][next[1]]) continue;
                queue.add(next);
                visit[next[0]][next[1]] = true;
            }
        }

        System.out.println(0);
    }
}
