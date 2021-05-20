package DP;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class boj18353_병사_배치하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = IntStream.range(0, N).map(i -> sc.nextInt()).boxed().collect(Collectors.toList());
        Collections.reverse(list);

        int[] memo = new int[N];
        for (int i = 0; i < N; i++) {
            memo[i] = 1;

            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i))
                    memo[i] = Math.max(memo[i], memo[j] + 1);
            }
        }
        System.out.println(N - Arrays.stream(memo).max().getAsInt());
    }
}
