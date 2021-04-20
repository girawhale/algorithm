package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2469_사다리_타기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        char[] dest = br.readLine().toCharArray();
        char[][] ladder = new char[N][];
        int point = 0;
        for (int i = 0; i < N; i++) {
            ladder[i] = br.readLine().toCharArray();
            if (ladder[i][0] == '?') point = i;
        }

        char[] start = new char[K];
        for (int i = 0; i < K; i++)
            start[i] = (char) ('A' + i);

        for (int i = 0; i < point; i++) {
            for (int j = 0; j < K - 1; j++) {
                if (ladder[i][j] == '-')
                    swap(start, j, j + 1);
            }
        }

        for (int i = N - 1; i > point; i--) {
            for (int j = 0; j < K - 1; j++) {
                if (ladder[i][j] == '-')
                    swap(dest, j, j + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K - 1; i++) {
            if (start[i] != dest[i]) {
                swap(start, i, i + 1);
                sb.append('-');
            } else sb.append('*');
        }

        if (!Arrays.equals(start, dest)) {
            System.out.println("x".repeat(K - 1));
        } else
            System.out.println(sb);

    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
