package 그리디;

import java.util.Scanner;
import java.util.stream.IntStream;

public class dbb0302_큰_수의_법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        int[] arr = IntStream.range(0, N).map(i -> sc.nextInt()).sorted().toArray();

        int cnt = M / (K + 1);
        System.out.println(arr[N - 1] * (M - cnt) + arr[N - 2] * cnt);


//        int i = 0;
//        int ans = 0;
//        while (i < M) {
//            if (M - i >= K) {
//                ans += arr[N - 1] * K + arr[N - 2];
//            } else {
//                ans += arr[N - 1] * (M - i);
//            }
//            i += K + 1;
//        }
    }
}