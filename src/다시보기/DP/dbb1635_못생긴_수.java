package 다시보기.DP;

import java.util.Scanner;

public class dbb1635_못생긴_수 { // http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=597
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] memo = new long[1501];
        memo[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        long next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i <= 1500; i++) {
            memo[i] = Math.min(next2, Math.min(next3, next5));

            if (memo[i] == next2) {
                next2 = memo[++i2] * 2;
            }
            if (memo[i] == next3) {
                next3 = memo[++i3] * 3;
            }
            if (memo[i] == next5) {
                next5 = memo[++i5] * 5;
            }
        }

        int N;
        while ((N = sc.nextInt()) != 0)
            System.out.println(memo[N - 1]);
    }

}
