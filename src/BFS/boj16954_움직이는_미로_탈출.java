package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj16954_움직이는_미로_탈출 {
    public static void main(String[] args) {
        char[] newLine = ".".repeat(8).toCharArray();
        int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1}, dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        Scanner sc = new Scanner(System.in);
        char[][] map = new char[8][8];
        for (int i = 0; i < 8; i++)
            map[i] = sc.next().toCharArray();

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit;
        queue.add(new int[]{7, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            visit = new boolean[8][8];

            while (size-- > 0) {
                int[] cur = queue.poll();

                if (map[cur[0]][cur[1]] == '#') continue;
                if (cur[0] == 0 && cur[1] == 7) {
                    System.out.println(1);
                    return;
                }

                for (int k = 0; k < 9; k++) {
                    int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                    if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || visit[ny][nx] || map[ny][nx] == '#') continue;
                    visit[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }

            for (int i = 7; i > 0; i--)
                map[i] = map[i - 1];
            map[0] = newLine;
        }
        System.out.println(0);
    }
}
