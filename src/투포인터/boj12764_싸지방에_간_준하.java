package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj12764_싸지방에_간_준하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());

            list.add(new int[]{s, 1, i});
            list.add(new int[]{e, -1, i});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] enter = new int[N];
        int sum = 0;

        for (int[] n : list) {
            sum += n[1];

            if (n[1] == 1) {
                enter[n[2]] = queue.isEmpty() ? sum : queue.poll();
                map.put(enter[n[2]], map.getOrDefault(enter[n[2]], 0) + 1);
            } else {
                queue.add(enter[n[2]]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.size()).append('\n');
        map.keySet().forEach(k -> sb.append(map.get(k)).append(' '));
        System.out.println(sb);
    }
}
