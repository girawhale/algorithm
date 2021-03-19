package 구현;

import java.util.Scanner;

public class boj2116_주사위_쌓기 {
    static int N;
    static int[] dir = {5, 3, 4, 1, 2, 0};
    static int[][] dice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dice = new int[N + 1][6];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 6; j++) dice[i][j] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 1; i <= 6; i++)
            ans = Math.max(ans, solve(1, i));

        System.out.println(ans);
    }

    static int solve(int idx, int top) {
        if (idx == N + 1) return 0;

        int b = 0, ret = 0;
        for (; b < 6; b++) {
            if (top == dice[idx][b]) {
                for (int i = 0; i < 6; i++) {
                    if (i == b || i == dir[b]) continue;
                    ret = Math.max(ret, dice[idx][i]);
                }
                return ret + solve(idx + 1, dice[idx][dir[b]]);
            }
        }
        return -1;
    }
}
