package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj20209_스트레이트_스위치_게임 {
    static int N, K, ans = Integer.MAX_VALUE;
    static int[] cubes, arr;
    static int[][] switches;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        cubes = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();
        switches = new int[K][];
        for (int i = 0; i < K; i++)
            switches[i] = IntStream.range(0, sc.nextInt()).map(in -> sc.nextInt() - 1).toArray();

        arr = new int[K];
        solve(0, 4 * K);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void solve(int idx, int remain) {
        if (idx == K) {
            int[] test = cubes.clone();
            for (int i = 0; i < K; i++) {
                for (int s : switches[i]) {
                    test[s] = (test[s] + arr[i] * (i + 1)) % 5;
                }
            }
            if (Arrays.stream(test).allMatch(t -> t == test[0]))
                ans = Math.min(Arrays.stream(arr).sum(), ans);

            return;
        }

        for (int i = 0; i <= Math.min(remain, 4); i++) {
            arr[idx] = i;
            solve(idx + 1, remain - i);
        }
    }
}
