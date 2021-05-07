package 완전탐색;

import java.util.*;

public class boj9328_열쇠 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
        int T = sc.nextInt();

        while (T-- > 0) {
            boolean[] keys = new boolean[26];
            int h = sc.nextInt(), w = sc.nextInt();

            char[][] map = new char[h][];
            for (int i = 0; i < h; i++)
                map[i] = sc.next().toCharArray();

            String input = sc.next();
            if (!input.equals("0"))
                input.chars().forEach(k -> keys[k - 'a'] = true);

            Queue<int[]> queue = new LinkedList<>();
            List[] after = new ArrayList[26];
            for (int i = 0; i < 26; i++) after[i] = new ArrayList();
            boolean[][] visit = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                if (map[i][0] != '*') queue.add(new int[]{i, 0});
                if (map[i][w - 1] != '*') queue.add(new int[]{i, w - 1});
            }
            for (int j = 0; j < w; j++) {
                if (map[0][j] != '*') queue.add(new int[]{0, j});
                if (map[h - 1][j] != '*') queue.add(new int[]{h - 1, j});
            }

            int ans = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if(visit[cur[0]][cur[1]]) continue;
                char ch = map[cur[0]][cur[1]];
                if (Character.isUpperCase(ch) && !keys[ch - 'A']) {
                    after[ch - 'A'].add(cur);
                    continue;
                }
                if (Character.isLowerCase(ch)) {
                    keys[ch - 'a'] = true;
                    queue.addAll(after[ch - 'a']);
                }
                if (ch == '$') ans++;

                visit[cur[0]][cur[1]] = true;
                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k], nx = cur[1] + dx[k];
                    if (ny < 0 || nx < 0 || ny >= h || nx >= w || map[ny][nx] == '*' || visit[ny][nx]) continue;

                    queue.add(new int[]{ny, nx});
                }
            }

            System.out.println(ans);
        }
    }
}
