package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i < N; i++) nums[i] += nums[i - 1];

        int len = Integer.MAX_VALUE, s = 0, e = 0;
        while (s < N && e < N) {
            int sum = nums[e] - (s > 0 ? nums[s - 1] : 0);
            if (sum >= S && len > e - s + 1) {
                len = e - s + 1;
            }
            if (sum < S) e++;
            else s++;
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
