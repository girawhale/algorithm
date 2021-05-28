package 구현;

import java.util.Scanner;

public class boj21771_가희야_거기서_자는_거_아니야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), C = sc.nextInt();
        sc.nextInt();
        sc.nextInt();
        int P = sc.nextInt() * sc.nextInt();

        for (int i = 0; i < R; i++) {
            P -= sc.next().chars().filter(j -> j == 'P').count();
        }

        System.out.println(P == 0 ? 0 : 1);
    }
}
