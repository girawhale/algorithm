package 구현;

import java.util.Scanner;

public class dbb0402_왕실의_나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dy = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};

        String in = sc.next();
        int y = in.charAt(0) - 'a' + 1;
        int x = in.charAt(1) - '0';

        int ans = 0;
        for (int k = 0; k < 8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny <= 0 || nx <= 0 || ny > 8 || nx > 8) continue;
            ans++;
        }
        System.out.println(ans);
    }
}
