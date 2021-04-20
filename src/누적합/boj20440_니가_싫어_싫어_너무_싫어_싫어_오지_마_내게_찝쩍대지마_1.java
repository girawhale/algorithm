package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj20440_니가_싫어_싫어_너무_싫어_싫어_오지_마_내게_찝쩍대지마_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            set.add(arr[i][0]);
            set.add(arr[i][1]);
        }

        int[] sum = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        list.sort(null);

        for (int i = 0; i < N; i++) {
            int start = Collections.binarySearch(list, arr[i][0]);
            int end = Collections.binarySearch(list, arr[i][1]);

            while (start < end) {
                sum[start++]++;
            }
        }

        int max = 0;
        int[] range = null;
        for (int i = 0; i < sum.length; i++) {
            if (max < sum[i]) {
                max = sum[i];
                int j = i;
                while (j < sum.length && sum[i] == sum[j])
                    j++;

                range = new int[]{list.get(i), list.get(j)};
            }
        }

        System.out.println(max);
        System.out.println(range[0] + " " + range[1]);
    }
}