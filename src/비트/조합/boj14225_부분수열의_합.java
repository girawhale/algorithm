package 비트.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj14225_부분수열의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] check = new boolean[20 * 100_000 + 1];

        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0)
                    sum += S[j];
            }
            check[sum] = true;
        }

        for (int i = 1; ; i++) {
            if (!check[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
