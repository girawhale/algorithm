package 다시보기.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class boj20952_게임_개발자_승희 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        boolean[] remain = new boolean[7];
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).peek(a -> remain[a % 7] = true).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = (int) IntStream.range(0, 7).filter(i -> remain[i]).count();

        long sum = 0;
        for (int b : B) {
            sum += b;
            int idx = (int) ((7 - (sum % 7)) % 7);

            if (!remain[idx]) continue;
            if (count == 1) {
                sum -= b;
                continue;
            }

            remain[idx] = false;
            count--;
        }

        List<Long> ans = new ArrayList<>();
        final int MOD = (int) (1e9) + 7;
        for (int a : A) {
            if (!remain[a % 7]) continue;

            ans.add((sum + a) % MOD);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        ans.forEach(i -> sb.append(i).append(' '));
        System.out.println(sb);
    }
}
