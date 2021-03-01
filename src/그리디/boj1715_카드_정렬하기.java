package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (N-- > 0)
            queue.add(Integer.parseInt(br.readLine()));

        int ans = 0;
        while (queue.size() > 1) {
            int tmp = queue.poll() + queue.poll();
            ans += tmp;
            queue.add(tmp);
        }

        System.out.println(ans);
    }
}
