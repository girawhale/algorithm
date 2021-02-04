import java.util.Scanner;

public class boj1039_교환 {
    static int N, K, len, max = -1;
    static int[] pow;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        len = String.valueOf(N).length();
        visit = new boolean[K][1_000_001];

        pow = new int[7];
        pow[0] = 1;
        for (int i = 1; i < 7; i++) pow[i] = pow[i - 1] * 10;

        solve(0, N);
        System.out.println(max);
    }

    static void solve(int cnt, int num) {
        if (cnt == K) {
            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = num;
                int n1 = tmp / pow[i] % 10;
                int n2 = tmp / pow[j] % 10;

                tmp = tmp - n1 * pow[i] - n2 * pow[j] +
                        n1 * pow[j] + n2 * pow[i];

                if (tmp < pow[len - 1] || visit[cnt][tmp]) continue;
                visit[cnt][tmp] = true;

                solve(cnt + 1, tmp);
            }
        }
    }
}
