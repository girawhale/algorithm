package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2003_수들의_합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            num[i] += num[i - 1] + Integer.parseInt(st.nextToken());

        int left = 0, right = 1;
        int ans = 0;
        while (left <= N && right <= N) {
            int sum = num[right] - num[left];
            if (sum == M) ans++;

            if (sum < M) right++;
            else left++;
        }
        System.out.println(ans);
    }
}
