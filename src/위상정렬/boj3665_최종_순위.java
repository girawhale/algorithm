package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3665_최종_순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean[][] adj = new boolean[N + 1][N + 1];
            int[] inDegree = new int[N + 1];

            for (int i = 0; i < N; i++) {
                inDegree[arr[i]] = i;
                for (int j = i + 1; j < N; j++) {
                    adj[arr[i]][arr[j]] = true;
                }
            }

            int M = Integer.parseInt(br.readLine());

            StringTokenizer st;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken()), n2 = Integer.parseInt(st.nextToken());
                adj[n1][n2] = !adj[n1][n2];
                adj[n2][n1] = !adj[n2][n1];
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) queue.add(i);
            }

            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < N; idx++) {
                if (queue.size() != 1) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }
                int cur = queue.poll();
                sb.append(cur).append(' ');

                for (int i = 1; i <= N; i++) {
                    if (adj[cur][i]) {
                        inDegree[i]--;
                        if (inDegree[i] == 0) queue.add(i);
                    }
                }
            }
            ans.append(sb).append('\n');
        }
        System.out.println(ans);

    }
}
