package 그리디;

import java.util.Scanner;

public class dbb0304_1이_될_때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        int cnt = 0;
        while (N > 1) {
            if (N % K == 0) {
                N /= K;
            } else {
                N--;
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
