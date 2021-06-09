package 다시보기.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj10800_컬러볼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] ball = new int[N][];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ball[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, 0};
        }
        Arrays.sort(ball, Comparator.comparingInt(o -> o[1]));
        int[] color = new int[N + 1];
        int sum = 0;

        for (int i = 0, j = 0; i < N; i++) {
            while (ball[j][1] < ball[i][1]) {
                sum += ball[j][1];
                color[ball[j][0]] += ball[j][1];
                j++;
            }
            ball[i][3] += sum - color[ball[i][0]];
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(ball).sorted(Comparator.comparingInt(o -> o[2]))
                .forEach(b -> sb.append(b[3]).append('\n'));

        System.out.println(sb);
    }
}