package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16719_ZOAC {
    static int[] printIdx;
    static String str;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int N = str.length();
        printIdx = new int[N];
        solve(0, N);

        StringBuilder print = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++)
                if (printIdx[j] <= i)
                    sb.append(str.charAt(j));

            print.append(sb).append('\n');
        }

        System.out.println(print);
    }

    static void solve(int left, int right) {
        if (left >= right) return;
        int minIdx = left;

        for (int i = left; i < right; i++) {
            if (str.charAt(minIdx) > str.charAt(i))
                minIdx = i;
        }

        printIdx[minIdx] = idx++;
        solve(minIdx + 1, right);
        solve(left, minIdx);
    }


}
