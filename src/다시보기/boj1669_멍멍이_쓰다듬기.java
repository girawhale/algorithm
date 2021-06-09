package 다시보기;

import java.util.Scanner;

public class boj1669_멍멍이_쓰다듬기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diff = -(sc.nextInt() - sc.nextInt());
        if (diff == 0) {
            System.out.println(0);
            return;
        }

        long n = 0;
        while (n * n < diff) {
            n++;
        }

        System.out.println(n * 2 - ((n * n - n < diff) ? 1 : 2));
    }
}
