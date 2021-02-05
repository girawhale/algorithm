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
            bfs();
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
        int idx = 0, ret = 0, cnt = 0;
        queue.add(new int[]{r, c, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (board[cur[0]][cur[1]] == perm[idx]) {
                queue.clear();
                visit = new boolean[4][4];
                ret += cur[2];

                if (cnt == 1) {
                    cnt = 0;
                    idx++;
                }
            }

            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];

                if (ny < 0 || nx < 0 || ny >= 4 || nx >= 4) continue;


            }

        }

        return Integer.MAX_VALUE;
    }
}
