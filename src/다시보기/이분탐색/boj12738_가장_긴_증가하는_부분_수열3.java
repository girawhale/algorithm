package 다시보기.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj12738_가장_긴_증가하는_부분_수열3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[N];

        int size = 0;
        for (int i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(lis, 0, size, arr[i]);

            if (idx >= 0) continue;
            idx = -idx - 1;
            lis[idx] = arr[i];
            if (idx == size) size++;
        }

        System.out.println(size);
    }
}