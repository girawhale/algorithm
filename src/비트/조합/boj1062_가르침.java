package 비트.조합;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1062_가르침 {
    static int[] wordBits;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt() - 5;

        wordBits = IntStream.range(0, N).map(i -> getBit(sc.next())).toArray();

        if (K < 0) {
            System.out.println(0);
            return;
        }
        comb(0, 0, getBit("antic"), K);
        System.out.println(ans);
    }

    static void comb(int i, int idx, int select, int cnt) {
        if (idx >= cnt) {
            ans = Math.max(ans, solve(select));
            return;
        }
        for (int j = i; j < 26; j++) {
            if ((select & (1 << j)) != 0) continue;
            comb(j + 1, idx + 1, (select | (1 << j)), cnt);
        }
    }

    static int solve(int select) {
        return (int) Arrays.stream(wordBits).filter(w -> (w & select) == w).count();
    }

    static int getBit(String word) {
        return word.chars().reduce(0, (s, i) -> s | (1 << (i - 'a')));
    }

}
