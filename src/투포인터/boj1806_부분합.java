package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            num[i] += num[i - 1] + Integer.parseInt(st.nextToken());

        int left = 0, right = 1;
        int ans = Integer.MAX_VALUE;

        while (left <= N && right <= N) {
            int sum = num[right] - num[left];
            if (sum >= S)
                ans = Math.min(ans, right - left);

            if (sum < S) right++;
            else left++;
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}

