package 플로이드와샬;

import java.util.Arrays;
import java.util.Scanner;

public class boj1956_운동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt(), MAX = 987654321;
        int[][] adj = new int[V + 1][V + 1];
        for (int[] a : adj)
            Arrays.fill(a, MAX);

        while (E-- > 0)
            adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++)
                for (int j = 1; j <= V; j++)
                    if (adj[i][j] > adj[i][k] + adj[k][j])
                        adj[i][j] = adj[i][k] + adj[k][j];
        }
        int ans = MAX;
        for (int i = 1; i <= V; i++)
            ans = Math.min(ans, adj[i][i]);

        System.out.println(ans == MAX ? -1 : ans);
    }
}
