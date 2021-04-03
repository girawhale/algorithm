package 재귀;

import java.util.Scanner;

public class boj20164_홀수_홀릭_호석 {
    static int max = 0, min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        solve(N, 0);
        System.out.print(min + " " + max);
    }

    static void solve(int n, int cnt) {
        cnt += getOddCount(n);
        int len = (int) Math.log10(n);

        if (len == 0) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }
        if (len == 1)
            solve((n % 10) + (n / 10), cnt);

        String numStr = Integer.toString(n);
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int sum = stoi(numStr.substring(0, i)) + stoi(numStr.substring(i, j)) + stoi(numStr.substring(j));

                solve(sum, cnt);
            }
        }
    }

    static int getOddCount(int n) {
        return (int) Integer.toString(n).chars().filter(i -> (i - '0') % 2 == 1).count();
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
