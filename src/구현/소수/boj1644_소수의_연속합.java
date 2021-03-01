package 구현.소수;

import java.util.Arrays;
import java.util.Scanner;

public class boj1644_소수의_연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;

        boolean[] prime = new boolean[N + 1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i <= N; i++) {
            if (!prime[i]) continue;
            for (int j = 2; i * j <= N; j++)
                prime[i * j] = false;
        }

        for (int i = 2; i <= N; i++) {
            if (!prime[i]) continue;

            int num = 0;
            for (int j = i; j <= N; j++) {
                if (!prime[j]) continue;

                num += j;
                if (num == N) cnt++;
                if (num >= N) break;
            }
        }

        System.out.println(cnt);
    }
}
