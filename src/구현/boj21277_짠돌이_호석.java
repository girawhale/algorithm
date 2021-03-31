package 구현;

import java.util.Scanner;

public class boj21277_짠돌이_호석 {
    static int N1, M1, N2, M2;
    static int[][] puzzle1, puzzle2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N1 = sc.nextInt();
        M1 = sc.nextInt();
        puzzle1 = new int[N1][];
        for (int i = 0; i < N1; i++)
            puzzle1[i] = sc.next().chars().map(in -> in - '0').toArray();

        N2 = sc.nextInt();
        M2 = sc.nextInt();
        puzzle2 = new int[N2][];
        for (int i = 0; i < N2; i++)
            puzzle2[i] = sc.next().chars().map(in -> in - '0').toArray();

        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            for (int n = -50; n <= 50; n++) {
                for (int m = -50; m <= 50; m++) {
                    if (isPossible(n, m)) {
                        int y = Math.max(N2, N1 + n) - Math.min(0, n);
                        int x = Math.max(M2, M1 + m) - Math.min(0, m);

                        ans = Math.min(ans, x * y);
                    }
                }
            }

            int[][] copyPuzzle = new int[M1][N1];
            for (int i = 0; i < M1; i++) {
                for (int j = 0; j < N1; j++)
                    copyPuzzle[i][j] = puzzle1[N1 - j - 1][i];
            }
            int tmp = N1;
            N1 = M1;
            M1 = tmp;
            puzzle1 = copyPuzzle;
        }

        System.out.println(ans);
    }

    static boolean isPossible(int y, int x) {
        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < M2; j++) {
                int py = i - y, px = j - x;
                if (py < 0 || px < 0 || py >= N1 || px >= M1) continue;

                if (puzzle1[py][px] == 1 && puzzle2[i][j] == 1) return false;
            }
        }
        return true;
    }
}
