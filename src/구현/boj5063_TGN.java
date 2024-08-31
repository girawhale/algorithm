package 구현;

import java.util.Scanner;

public class boj5063_TGN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int r = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();

            switch (Integer.signum((e - c) - r)) {
                case 1 -> System.out.println("advertise");
                case -1 -> System.out.println("do not advertise");
                default -> System.out.println("does not matter");
            }
        }
    }
}
