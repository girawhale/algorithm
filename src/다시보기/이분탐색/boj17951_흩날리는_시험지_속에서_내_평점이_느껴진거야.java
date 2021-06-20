package 다시보기.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17951_흩날리는_시험지_속에서_내_평점이_느껴진거야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0, e = Integer.MAX_VALUE, ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;

            int count = 0, sum = 0;
            for (int i = 0; i < N; i++) {
                sum += score[i];
                if (sum >= mid) {
                    count++;
                    sum = 0;
                }
            }

            if (count >= K) {
                ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }

        System.out.println(ans);
    }
}
