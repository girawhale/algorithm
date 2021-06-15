package 다시보기.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12015_가장_긴_증가하는_부분_수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[N];

        list.add(arr[0]);
        cnt[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] <= list.get(list.size() - 1)) {
                int idx = Collections.binarySearch(list, arr[i]);
                if (idx >= 0) {
                    cnt[i] = idx + 1;
                } else {
                    idx = -idx - 1;
                    list.set(idx, arr[i]);
                    cnt[i] = idx + 1;
                }
            } else {
                list.add(arr[i]);
                cnt[i] = list.size();
            }
        }

        System.out.println(list.size());
    }
}
