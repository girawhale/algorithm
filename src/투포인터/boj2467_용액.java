package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = Integer.MAX_VALUE, ans1 = -1, ans2 = -1, s = 0, e = N - 1;
        while (s < e) {
            int tmp = arr[s] + arr[e];
            if (ans > Math.abs(tmp)) {
                ans = Math.abs(tmp);
                ans1 = s;
                ans2 = e;
            }

            if (tmp < 0) s++;
            else if (tmp > 0) e--;
            else break;
        }
        System.out.println(arr[ans1] + " " + arr[ans2]);
    }
}
