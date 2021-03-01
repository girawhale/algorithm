package 백트래킹;

import java.util.Scanner;

public class boj2661_좋은수열 {
    static int N;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        solve(0);
    }

    static void solve(int n) {
        for (int l = 1; l <= n / 2; l++) {
            boolean ck = true;
            for (int j = 0; j < l; j++)
                ck &= nums[n - j - 1] == nums[n - l - j - 1];

            if (ck) return;
        }


        if (n == N) {
            StringBuilder sb = new StringBuilder();
            for (int i : nums) sb.append(i);
            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            nums[n] = i;
            solve(n + 1);
        }
    }
}
