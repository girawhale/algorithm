package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dbb1528_고정점_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0, e = N;
        while (s <= e) {
            int m = (s + e) / 2;

            if (arr[m] == m) {
                System.out.println(m);
                return;
            }
            if (arr[m] < m) s = m + 1;
            else e = m - 1;
        }
        System.out.println(-1);
    }
}
