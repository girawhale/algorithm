package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2473_세_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] ph = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).sorted().toArray();

        long ans = Long.MAX_VALUE;
        int[] arr = null;
        for (int i = 0; i < N; i++) {
            int j = i + 1, k = N - 1;
            while (j < k) {
                long tmp = ph[i] + ph[j] + ph[k];
                if (ans > Math.abs(tmp)) {
                    ans = Math.abs(tmp);
                    arr = new int[]{i, j, k};
                }

                if (tmp < 0) j++;
                else if (tmp > 0) k--;
                else break;
            }
        }
        Arrays.stream(arr).forEach(i -> System.out.print(ph[i] + " "));
    }
}
