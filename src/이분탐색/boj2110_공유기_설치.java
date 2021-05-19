package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2110_공유기_설치 { // dbb1529
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int s = 0, e = (int) 1e9, ans = 0;

        while (s <= e) {
            int m = (s + e) / 2;

            if (getCount(arr, m) >= C) {
                ans = m;
                s = m + 1;
            } else e = m - 1;
        }
        System.out.println(ans);
    }

    static int getCount(int[] arr, int dist) {
        int cnt = 1;
        int prev = arr[0];

        for (int a : arr) {
            if (a - prev >= dist) {
                cnt++;
                prev = a;
            }
        }

        return cnt;
    }


}
