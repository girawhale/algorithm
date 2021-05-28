package disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class boj10775_공항 { // dbb1842_탑승구
    static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        used = IntStream.rangeClosed(0, G).toArray();
        int idx = 0;
        while (idx < P) {
            int g = Integer.parseInt(br.readLine());
            if (find(g) == 0) break;

            union(g, find(g) - 1);
            idx++;
        }
        System.out.println(idx);
    }

    static int find(int n) {
        return used[n] = used[n] == n ? n : find(used[n]);
    }

    static void union(int n1, int n2) {
        used[find(n1)] = find(n2);
    }
}
