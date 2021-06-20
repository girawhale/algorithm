package 투포인터;

import java.util.Comparator;
import java.util.PriorityQueue;

public class prog17676_추석_트래픽 {
    public int solution(String[] lines) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator
                .<int[]>comparingInt(o -> o[0])
                .thenComparing(o -> o[1]));

        for (String line : lines) {
            String[] split = line.split(" ");

            int end = stringToIntTime(split[1]);
            int start = end - (int) (Double.parseDouble(split[2].substring(0, split[2].length() - 1)) * 1000);

            pq.add(new int[]{start, 1});
            pq.add(new int[]{end + 999, -1});
        }

        int max = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            count += pq.poll()[1];
            max = Math.max(max, count);
        }

        return max;
    }

    int stringToIntTime(String str) {
        return Integer.parseInt(str.substring(0, 2)) * 60 * 60 * 1000
                + Integer.parseInt(str.substring(3, 5)) * 60 * 1000
                + Integer.parseInt(str.substring(6, 8)) * 1000
                + Integer.parseInt(str.substring(9, 12));
    }
}
