package DP;

import java.util.Arrays;
import java.util.Scanner;

public class boj2056_작업 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] memo = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int time = memo[i] = sc.nextInt();

            int m = sc.nextInt();
            while (m-- > 0) {
                int n = sc.nextInt();
                memo[i] = Math.max(memo[i], memo[n] + time);
            }
        }

        System.out.println(Arrays.stream(memo).max().getAsInt());
    }
}
