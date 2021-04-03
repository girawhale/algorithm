package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class boj21275_폰_호석만 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aStr = sc.next(), bStr = sc.next();

        long[] ans = null;
        for (int a = 2; a <= 36; a++) {
            for (int b = 2; b <= 36; b++) {
                if (a == b) continue;
                try {
                    long aTmp = Long.parseLong(aStr, a);
                    long bTmp = Long.parseLong(bStr, b);

                    if (aTmp == bTmp) {
                        if (ans == null) {
                            ans = new long[]{aTmp, a, b};
                        } else {
                            System.out.println("Multiple");
                            return;
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }

        if (ans == null) System.out.println("Impossible");
        else Arrays.stream(ans).forEach(a -> System.out.print(a + " "));

    }
}
