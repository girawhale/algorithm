package 그리디;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class dbb0303_숫자_카드_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        int[] min = new int[N];
        for (int i = 0; i < N; i++) {
            min[i] = IntStream.range(0, M).map(ii -> sc.nextInt()).min().getAsInt();
        }

        System.out.println(Arrays.stream(min).max().getAsInt());
    }
}
