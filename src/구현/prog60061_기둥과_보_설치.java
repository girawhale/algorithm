package 구현;

import java.util.ArrayList;
import java.util.List;

public class prog60061_기둥과_보_설치 {
    int N;
    boolean[][] pillars, beams;
    int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        pillars = new boolean[n + 1][n + 1];
        beams = new boolean[n + 1][n + 1];

        for (int[] b : build_frame) {
            if (b[3] == 1) {
                if (b[2] == 0) pillars[b[0]][b[1]] = checkPillar(b);
                else if (b[2] == 1) beams[b[0]][b[1]] = checkBeam(b);
            } else {
                boolean[][] tmp = b[2] == 0 ? pillars : beams;
                tmp[b[0]][b[1]] = false;

                for (int k = 0; k < 9; k++) {
                    int x = b[0] + dx[k], y = b[1] + dy[k];
                    if(x < 0 || y < 0 || x > n || y > n) continue;

                    if ((beams[x][y] && !checkBeam(new int[]{x, y})) ||
                            (pillars[x][y] && !checkPillar(new int[]{x, y}))) {
                        tmp[b[0]][b[1]] = true;
                        break;
                    }
                }
            }
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillars[i][j]) ans.add(new int[]{i, j, 0});
                if (beams[i][j]) ans.add(new int[]{i, j, 1});
            }
        }

        return ans.toArray(new int[0][]);
    }

    boolean checkPillar(int[] b) {
        return b[1] == 0 || pillars[b[0]][b[1] - 1] || (b[0] > 0 && beams[b[0] - 1][b[1]]) || beams[b[0]][b[1]];
    }

    boolean checkBeam(int[] b) {
        return pillars[b[0]][b[1] - 1] || pillars[b[0] + 1][b[1] - 1] ||
                b[0] > 0 && b[0] < N && beams[b[0] - 1][b[1]] && beams[b[0] + 1][b[1]];
    }
}
