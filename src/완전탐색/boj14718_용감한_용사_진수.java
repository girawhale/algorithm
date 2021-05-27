package 완전탐색;

import java.util.*;

public class boj14718_용감한_용사_진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = sc.nextInt();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int[] a : arr) {
                        if (arr[i][0] >= a[0] && arr[j][1] >= a[1] && arr[k][2] >= a[2]) cnt++;
                    }
                    if (cnt >= K) {
                        ans = Math.min(ans, arr[i][0] + arr[j][1] + arr[k][2]);
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
