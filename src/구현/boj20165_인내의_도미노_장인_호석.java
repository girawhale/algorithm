package 구현;

import java.util.Scanner;

public class boj20165_인내의_도미노_장인_호석 {
    public static void main(String[] args) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        String dir = "WENS";

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[][] origin = new int[N + 1][M + 1];
        int[][] domino = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                origin[i][j] = domino[i][j] = sc.nextInt();


        int score = 0;
        while (R-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = dir.indexOf(sc.next().charAt(0));

            int len = domino[x][y];
            int cnt = 0;

            while (true) {
                if (y < 0 || y > M || x < 0 || x > N || cnt >= len) break;

                len = Math.max(len, domino[x][y] + cnt);
                if (domino[x][y] != 0) score++;
                domino[x][y] = 0;

                y += dy[d];
                x += dx[d];
                cnt++;
            }

            x = sc.nextInt();
            y = sc.nextInt();
            domino[x][y] = origin[x][y];
        }

        System.out.println(score);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++)
                System.out.print((domino[i][j] == 0 ? 'F' : 'S') + " ");
            System.out.println();
        }
    }
}
