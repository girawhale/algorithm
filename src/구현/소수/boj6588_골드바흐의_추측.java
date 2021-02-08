package 구현.소수;

import java.util.Arrays;
import java.util.Scanner;

public class boj6588_골드바흐의_추측 {
    static boolean[] prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prime = new boolean[1_000_001];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!prime[i]) continue;
            for (int j = 2; i * j <= 1000000; j++)
                prime[i * j] = false;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            int[] ret = solve(n);
            sb.append(ret == null ? "Goldbach's conjecture is wrong." :
                    String.format("%d = %d + %d", n, ret[0], ret[1])).append('\n');
        }
        System.out.println(sb.toString());
    }

    static int[] solve(int n) {
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) continue;
            if (prime[i] & prime[n - i]) return new int[]{i, n - i};
        }
        return null;
    }
}
