package 완전탐색;

import java.util.Arrays;
import java.util.Scanner;

public class boj1759_암호_만들기 {
    static int L, C;
    static char[] select, arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        arr = new char[C];
        select = new char[L];
        for (int i = 0; i < C; i++) arr[i] = sc.next().charAt(0);
        Arrays.sort(arr);

        solve(0, 0, 0);
        System.out.println(sb);
    }

    static void solve(int idx, int cnt, int aeiou) {
        if (cnt == L) {
            if (aeiou >= 1 && (cnt - aeiou) >= 2)
                sb.append(select).append('\n');
            return;
        }
        if (idx >= C) return;

        for (int i = idx; i < C; i++) {
            select[cnt] = arr[i];
            solve(i + 1, cnt + 1, "aeiou".indexOf(arr[i]) >= 0 ? aeiou + 1 : aeiou);
        }
    }
}
