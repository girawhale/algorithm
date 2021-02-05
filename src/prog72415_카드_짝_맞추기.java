import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prog72415_카드_짝_맞추기 {
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1}, perm;
    boolean[] visit;
    int cardCnt, ans = Integer.MAX_VALUE, r, c;
    int[][] board;

    public int solution(int[][] board, int r, int c) {
        for (int i = 0; i < 4; i++)
            cardCnt = Math.max(cardCnt, Arrays.stream(board[i]).max().getAsInt());

        perm = new int[cardCnt + 1];
        visit = new boolean[cardCnt + 1];
        this.r = r;
        this.c = c;
        this.board = board;

        permutation(1);

        return ans;
    }

    void permutation(int cnt) {
        if (cnt > cardCnt) {
            ans = Math.min(ans, bfs());
            System.out.println(ans);
            return;
        }

        for (int i = 1; i <= cardCnt; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            perm[cnt] = i;
            permutation(cnt + 1);
            visit[i] = false;
        }
    }

    int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[4][4];
        int idx = 1, ret = 0, cnt = 0;
        queue.add(new int[]{r, c, 0});
        System.out.println(Arrays.toString(perm));

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            System.out.println(Arrays.toString(cur));

            if (board[cur[0]][cur[1]] == perm[idx]) {
                queue.clear();
                visit = new boolean[4][4];
                ret += cur[2];
                visit[cur[0]][cur[1]] = true;
                queue.add(new int[]{cur[0], cur[1], 0});

                if (cnt == 1) {
                    cnt = 0;
                    idx++;
                    if (idx > cardCnt) return ret;
                }

                if (ret >= ans) return Integer.MAX_VALUE;
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];

                if (!(ny < 0 || nx < 0 || ny >= 4 || nx >= 4 || visit[ny][nx])) {
                    visit[ny][nx] = true;
                    queue.add(new int[]{ny, nx, cur[2] + 1});
                }

                while (true) {
                    if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4) {
                        ny -= dy[k];
                        nx -= dx[k];
                        break;
                    }
                    ny += dy[k];
                    nx += dx[k];

                    if (board[ny][nx] != 0) break;
                }

                if (visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx, cur[2] + 1});
            }

        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new prog72415_카드_짝_맞추기()
                .solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
    }
}
