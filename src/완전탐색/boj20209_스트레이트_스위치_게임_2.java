package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj20209_스트레이트_스위치_게임_2 {
    static int N, K, ans = Integer.MAX_VALUE;
    static int[] cubes;
    static int[][] switches;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        cubes = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();
        switches = new int[K][];
        for (int i = 0; i < K; i++)
            switches[i] = IntStream.range(0, sc.nextInt()).map(in -> sc.nextInt() - 1).toArray();

        solve(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void solve(int idx, int cnt) {
        if (idx == K) {
            if (Arrays.stream(cubes).allMatch(t -> t == cubes[0]))
                ans = Math.min(cnt, ans);
            return;
        }

        for (int i = 0; i <= 4; i++) {
            solve(idx + 1, cnt + i);
            for (int s : switches[idx]) {
                cubes[s] += (idx + 1);
                cubes[s] %= 5;
            }
        }
    }
}
