package 구현;

import java.util.Scanner;

public class boj16967_배열_복원하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt();

        int[][] arr = new int[H + X][W + Y];
        int[][] A = new int[H][W];

        for (int i = 0; i < H + X; i++)
            for (int j = 0; j < W + Y; j++)
                arr[i][j] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = arr[i][j];

                if (i - X >= 0 && i - X < H && j - Y >= 0 && j - Y < W)
                    A[i][j] -= A[i - X][j - Y];
                sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
