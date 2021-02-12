package LCS;

import java.util.Scanner;

public class boj9252_LCS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = " " + sc.next(), str2 = " " + sc.next();
        int len1 = str1.length(), len2 = str2.length();
        int[][] memo = new int[len1][len2];

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++)
                memo[i][j] = str1.charAt(i) == str2.charAt(j) ?
                        memo[i - 1][j - 1] + 1 : Math.max(memo[i - 1][j], memo[i][j - 1]);
        }

        System.out.println(memo[len1 - 1][len2 - 1]);
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1, j = len2 - 1;
        while (memo[i][j] > 0) {
            if (memo[i - 1][j] == memo[i][j])
                i--;
            else if (memo[i][j - 1] == memo[i][j])
                j--;
            else {
                sb.append(str1.charAt(i));
                i--;
                j--;
            }
        }

        System.out.println(sb.reverse().toString());
    }
}
