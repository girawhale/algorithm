package disjoint;

import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1976_여행_가자 { //dbb1841_여행_계획
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();

        parent = IntStream.rangeClosed(0, N).toArray();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (sc.nextInt() == 1)
                    union(i, j);
            }
        }

        int p = find(sc.nextInt());
        while (M-- > 1) {
            if (p != find(sc.nextInt())) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int find(int n) {
        return parent[n] = parent[n] == n ? n : find(parent[n]);
    }

    static void union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);

        if (p1 == p2) return;
        if (p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }
}
