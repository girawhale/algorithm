package 구현;

import java.util.Scanner;

public class boj2166_다각형의_면적 { // 가우스의 면적 공식(신발끈)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] point = new long[N][2];
        for (int i = 0; i < N; i++) {
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
        }

        double sum = point[N - 1][0] * point[0][1] - point[0][0] * point[N - 1][1];
        for (int i = 0; i < N - 1; i++)
            sum += point[i][0] * point[i + 1][1] - point[i + 1][0] * point[i][1];

        System.out.printf("%.1f", Math.abs(sum / 2));
    }

}
