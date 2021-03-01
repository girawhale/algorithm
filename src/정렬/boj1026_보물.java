package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class boj1026_보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N], B = new int[N];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) B[i] = -sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);

        int S = 0;
        for (int i = 0; i < N; i++) S += A[i] * -B[i];
        System.out.println(S);
    }
}
