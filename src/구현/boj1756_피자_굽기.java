package 구현;

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

        int idx = D;
        for (int i = 0; i < N; i++) {
            idx--;
            while (idx >= 0 && pizza[i] > min[idx]) idx--;
        }
        System.out.println(idx < 0 ? 0 : idx + 1);
    }

    static int[] inputToIntArray(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
