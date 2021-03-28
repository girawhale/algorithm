package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1756_피자_굽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] oven = inputToIntArray(br.readLine());
        int[] pizza = inputToIntArray(br.readLine());

        int[] min = new int[D];
        min[0] = oven[0];
        for (int i = 1; i < D; i++) min[i] = Math.min(min[i - 1], oven[i]);

        int prevIdx = D;
        for (int i = 0; i < N; i++) {
            int s = 0, e = prevIdx - 1;
            while (s < e) {
                int m = (s + e) / 2;

                if (min[m] >= pizza[i]) s = m + 1;
                else e = m;
            }
            if (e < 0) {
                System.out.println(0);
                return;
            }
            prevIdx = e;
        }
        System.out.println(prevIdx + 1);
    }

    static int[] inputToIntArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
