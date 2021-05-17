package 완전탐색;

import java.util.Scanner;

public class boj14888_연산자_끼워넣기 {
    static int[] A, op;
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        op = new int[4];
        for (int i = 0; i < 4; i++)
            op[i] = sc.nextInt();

        solve(1, A[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static void solve(int idx, int ret) {
        if (idx == N) {
            min = Math.min(ret, min);
            max = Math.max(ret, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;

            int num = ret;
            if (i == 0) {
                num += A[idx];
            } else if (i == 1) {
                num -= A[idx];
            } else if (i == 2) {
                num *= A[idx];
            } else {
                num /= A[idx];
            }
            op[i]--;
            solve(idx + 1, num);
            op[i]++;
        }

    }
}
