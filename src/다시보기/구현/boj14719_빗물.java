package 다시보기.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
        int[] block = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;
            for (int l = i; l >= 0; l--) left = Math.max(block[l], left);
            for (int r = i; r < W; r++) right = Math.max(block[r], right);

            ans += Math.min(left, right) - block[i];
        }

        System.out.println(ans);
    }
}
