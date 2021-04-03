package 자료구조.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class prog42627_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        int N = jobs.length;
        int ans = 0, time = 0, idx = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (idx < N || !queue.isEmpty()) {
            while (idx < N && jobs[idx][0] <= time)
                queue.add(jobs[idx++]);

            if (!queue.isEmpty()) {
                int[] job = queue.poll();
                ans += ((time - job[0]) + job[1]);
                time += job[1];
            } else time = jobs[idx][0];
        }

        return ans / N;
    }
}
