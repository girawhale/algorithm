package DP;

import java.util.Scanner;
import java.util.stream.IntStream;

public class dbb0803_개미_전사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();

        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < N; i++)
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);

        System.out.println(arr[N - 1]);
    }
}
