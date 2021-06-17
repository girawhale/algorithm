package 다시보기.LIS;

import java.util.*;
import java.util.stream.IntStream;

public class boj2631_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = IntStream.range(0, N).map(i -> sc.nextInt()).toArray();

        List<Integer> list = new ArrayList<>();
        int[] lis = new int[N];

        list.add(arr[0]);
        lis[0] = 1;

        for (int i = 0; i < N; i++) {
            if (arr[i] <= list.get(list.size() - 1)) {
                int idx = Collections.binarySearch(list, arr[i]);

                if (idx >= 0) {
                    lis[i] = idx + 1;
                } else {
                    idx = -idx - 1;
                    list.set(idx, arr[i]);
                    lis[i] = idx + 1;
                }
            } else {
                list.add(arr[i]);
                lis[i] = list.size();
            }
        }
        System.out.println(N - list.size());
    }
}
