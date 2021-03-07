package 구현;

public class prog60059_자물쇠와_열쇠 {
    int N, M;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        for (int k = 0; k < 4; k++) {
            for (int i = -M; i < N; i++) {
                for (int j = -M; j < N; j++)
                    if (solve(key, lock, i, j)) return true;
            }

            int[][] rotate = new int[M][M];
            for (int i = 0; i < M; i++)
                for (int j = 0; j < M; j++)
                    rotate[i][j] = key[M - j - 1][i];
            key = rotate;
        }

        return false;
    }

    boolean solve(int[][] key, int[][] lock, int y, int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int ky = i - y, kx = j - x, k;
                if (ky < 0 || kx < 0 || ky >= M || kx >= M) k = 0;
                else k = key[ky][kx];

                if (lock[i][j] == k) return false;
            }
        }
        return true;
    }
}
