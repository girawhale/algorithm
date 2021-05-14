package 구현;

import java.util.Scanner;

public class ddb04ex2_시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 0;
        for (int time = 0; time < (N + 1) * 60 * 60; time++) {
            if (timeToStr(time).contains("3")) ans++;
        }

        System.out.println(ans);
    }

    static String timeToStr(int n) {
        return n / 60 / 60 + " " + n / 60 % 60 + " " + n % 60;
    }
}
