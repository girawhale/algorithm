package 구현.GCD;

import java.util.Arrays;
import java.util.Scanner;

public class boj2485_가로수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] tree = new int[N];
        for (int i = 0; i < N; i++) tree[i] = sc.nextInt();
        Arrays.sort(tree);

        int diff = tree[1] - tree[0];
        for (int i = 2; i < N; i++) {
            int t = tree[i] - tree[i - 1];
            diff = gcd(Math.max(diff, t), Math.min(diff, t));
        }

        System.out.println(((tree[N - 1] - tree[0]) / diff) - N + 1);
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
