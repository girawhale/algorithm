package 다시보기.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1202_보석_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, Comparator.comparingInt(j -> j[0]));
        Arrays.sort(bags);

        int idx = 0;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int bag : bags) {
            while (idx < N && jewel[idx][0] <= bag) {
                pq.add(-jewel[idx++][1]);
            }

            System.out.println(pq);
            if (!pq.isEmpty()) ans += -pq.poll();
        }
        System.out.println(ans);
    }
}