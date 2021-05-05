package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3151_합이_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        long ans = 0;
        for (int fix = 0; fix < N; fix++) {
            int l = fix + 1, r = N - 1;
            while (l < r) {
                int tmp = A[fix] + A[l] + A[r];
                if (tmp < 0) {
                    l++;
                } else if (tmp > 0) {
                    r--;
                } else {
                    if (A[r] == A[l]) {
                        int count = 0;
                        while (l + count < N && A[l + count] == A[l]) count++;

                        ans += (long) (count - 1) * count / 2;
                        break;

                    } else {
                        int nl = l + 1, nr = r - 1;
                        while (nl < r && A[nl] == A[l])
                            nl++;
                        while (nr > l && A[nr] == A[r])
                            nr--;

                        ans += (long) (nl - l) * (r - nr);
                        l = nl;
                        r = nr;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
