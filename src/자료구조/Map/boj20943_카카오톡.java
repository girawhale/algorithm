package 자료구조.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class boj20943_카카오톡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double key = in[0] == 0 ? 0 : in[1] == 0 ? Double.POSITIVE_INFINITY : (double) in[0] / in[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (int value : map.values())
            ans += (N - value) * value;

        System.out.println(ans / 2);
    }
}
