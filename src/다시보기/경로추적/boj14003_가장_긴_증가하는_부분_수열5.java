package 다시보기.경로추적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class boj14003_가장_긴_증가하는_부분_수열5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[N];
        int[] cnt = new int[N];

        int size = 0;
        for (int i = 0; i < N; i++) {
            int idx = Arrays.binarySearch(lis, 0, size, arr[i]);

            if (idx >= 0) continue;
            idx = -idx - 1;
            lis[idx] = arr[i];
            cnt[i] = idx;
            if (idx == size) size++;
        }

        System.out.println(size);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int j = N - 1; j >= 0 && size > 0; j--) {
            if (cnt[j] == size - 1) {
                stack.push(arr[j]);
                size--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(' ');
        System.out.println(sb);
    }
}
