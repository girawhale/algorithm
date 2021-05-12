package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dbb1101_모험가_길드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int cnt = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            cnt++;

            if (cnt >= arr[i]) {
                ans++;
                cnt = 0;
            }
        }
        System.out.println(ans);
    }
}
