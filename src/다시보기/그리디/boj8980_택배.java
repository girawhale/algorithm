package 다시보기.그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj8980_택배 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), C = sc.nextInt();
        int M = sc.nextInt();

        int[] capacity = new int[N];
        Arrays.fill(capacity, C);

        int[][] infos = new int[M][];
        for (int i = 0; i < M; i++) {
            infos[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }
        Arrays.sort(infos, Comparator.comparingInt(i -> i[1]));

        int ans = 0;
        for (int[] info : infos) {
            int min = Math.min(info[2], IntStream.range(info[0], info[1]).map(i -> capacity[i]).min().getAsInt());

            ans += min;
            IntStream.range(info[0], info[1]).forEach(i -> capacity[i] -= min);
        }
        System.out.println(ans);
    }
}
