package 문자열.KMP;

import java.io.*;

public class boj16916_부분_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] pi = new int[P.length];
        int j = 0;
        for (int i = 1; i < P.length; i++) {
            while (j > 0 && P[i] != P[j])
                j = pi[j - 1];

            if (P[i] == P[j])
                pi[i] = ++j;
        }

        j = 0;
        for (int i = 0; i < S.length; i++) {
            while (j > 0 && S[i] != P[j])
                j = pi[j - 1];

            if (S[i] == P[j]) {
                if (++j == P.length) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
