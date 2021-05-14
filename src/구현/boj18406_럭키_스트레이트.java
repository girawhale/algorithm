package 구현;

import java.util.Scanner;

public class boj18406_럭키_스트레이트 { // dbb1207_럭키_스트레이트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int left = 0;
        int right = 0;
        for (int i = 0; i < N.length(); i++) {
            int tmp = N.charAt(i) - '0';
            if (i < N.length() / 2)
                left += tmp;
            else right += tmp;
        }
        System.out.println(left == right ? "LUCKY" : "READY");
    }

}
