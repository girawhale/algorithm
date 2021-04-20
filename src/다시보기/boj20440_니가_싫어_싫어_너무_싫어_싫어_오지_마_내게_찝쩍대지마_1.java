package 다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20440_니가_싫어_싫어_너무_싫어_싫어_오지_마_내게_찝쩍대지마_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        int max = 0;
        int start = 0, end = 0;
        for (int[] a : arr) {
            while (!queue.isEmpty() && queue.peek()[1] <= a[0])
                queue.poll();

            queue.add(a);

            if (max < queue.size()) {
                max = queue.size();
                start = a[0];
                end = queue.peek()[1];
            } else if (a[0] == end && max == queue.size()) {
                end = queue.peek()[1];
            }
        }

        System.out.println(max);
        System.out.println(start + " " + end);
    }


}