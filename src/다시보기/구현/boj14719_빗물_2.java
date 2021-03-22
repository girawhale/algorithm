package 다시보기.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj14719_빗물_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
        int[] block = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] max = new int[W];
        int maxVal = 0;
        for (int l = 0; l < W; l++) {
            maxVal = Math.max(block[l], maxVal);
            max[l] = maxVal;
        }

        maxVal = 0;
        for (int r = W - 1; r >= 0; r--) {
            maxVal = Math.max(block[r], maxVal);
            max[r] = Math.min(maxVal, max[r]);
        }

        System.out.println(IntStream.range(0, W)
                .reduce((sum, i) -> sum + max[i] - block[i]).getAsInt());
    }
}
