package 자료구조.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21773_가희와_프로세스_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.<Process>comparingInt(p -> -p.priority).thenComparing(p -> p.id));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Process(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0 && pq.size() > 0) {
            Process process = pq.poll();
            process.priority--;
            process.time--;
            sb.append(process.id).append('\n');

            if (process.time != 0)
                pq.add(process);
        }
        System.out.println(sb);
    }

    static class Process {
        int id, time, priority;

        public Process(int id, int time, int priority) {
            this.id = id;
            this.time = time;
            this.priority = priority;
        }
    }
}
