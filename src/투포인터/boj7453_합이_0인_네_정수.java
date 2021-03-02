package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class boj7453_합이_0인_네_정수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][4];
        int[] prev = new int[N * N], post = new int[N * N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                prev[i * N + j] = arr[i][0] + arr[j][1];
                post[i * N + j] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(prev);
        Arrays.sort(post);

        int prevIdx = 0, postIdx = N * N - 1;
        long ans = 0;
        while (prevIdx < N * N && postIdx >= 0) {
            int sum = prev[prevIdx] + post[postIdx];

            if (sum == 0) {
                int prevSize = prevIdx, postSize = postIdx;
                while (prevIdx < N * N && prev[prevSize] == prev[prevIdx]) prevIdx++;
                while (postIdx >= 0 && post[postSize] == post[postIdx]) postIdx--;

                ans += (long) (prevIdx - prevSize) * (postSize - postIdx);
            } else if (sum < 0) prevIdx++;
            else postIdx--;
        }
        System.out.println(ans);
    }
}
