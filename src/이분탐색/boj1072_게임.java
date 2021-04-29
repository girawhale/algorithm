package 이분탐색;

import java.util.Scanner;

public class boj1072_게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        int z = getPercent(x, y);

        int ans = -1, l = 0, r = (int) 1e9;
        while (l <= r) {
            int m = (l + r) / 2;

            if (getPercent(x + m, y + m) != z) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
