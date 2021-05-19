package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805_나무_자르기 { // dbb0703_떡볶이_떡_만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0, e = (int) 1e9, ans = 0;

        while (s <= e) {
            int mid = (s + e) / 2;

            int sum = Arrays.stream(tree).map(i -> i > mid ? i - mid : 0).sum();
            if (sum >= M) {
                ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }
        System.out.println(ans);
    }
}
