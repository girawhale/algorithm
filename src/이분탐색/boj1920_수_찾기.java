package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1920_수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        br.readLine();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> sb.append(Arrays.binarySearch(arr, i) >= 0 ? 1 : 0).append('\n'));
        System.out.println(sb);
    }
}
