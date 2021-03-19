package 구현;

import java.util.Scanner;

public class boj3495_아스키_도형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        double ans = 0;
        for (int i = 0; i < h; i++) {
            boolean check = false;
            for (char ch : sc.next().toCharArray()) {
                if (ch == '\\' || ch == '/') {
                    ans += 0.5;
                    check = !check;
                } else if (check) ans += 1;
            }
        }
        System.out.println((int) ans);
    }
}
