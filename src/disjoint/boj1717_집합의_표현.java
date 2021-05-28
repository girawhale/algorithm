package disjoint;

import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1717_집합의_표현 { //dbb1002_팀_결성
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        parent = IntStream.rangeClosed(0, N).toArray();

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int op = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

            if (op == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
            }
        }
        System.out.println(sb);
    }

    static int find(int n) {
        return parent[n] = parent[n] == n ? n : find(parent[n]);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }
}
