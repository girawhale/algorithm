package 그리디;

import java.util.Scanner;

public class dbb1105_볼링공_고르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] cnt = new int[M + 1];
        for (int i = 0; i < N; i++) {
            cnt[sc.nextInt()]++;
        }

        int sum = 0;
        for (int i = 1; i <= M; i++) {
            N -= cnt[i];
            sum += cnt[i] * N;
        }
        System.out.println(sum);


//        N * M의 풀이
//
//        int[] cnt = new int[M + 1];
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++) {
//            arr[i] = sc.nextInt();
//            cnt[arr[i]]++;
//        }
//        int sum = 0;
//        for (int a : arr) {
//            for (int i = a + 1; i <= M; i++) {
//                sum += cnt[i];
//            }
//        }
//        System.out.println(sum);
    }
}
//5 3
//1 3 2 3 2

//8 5
//1 5 4 3 2 4 5 2