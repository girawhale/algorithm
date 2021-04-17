package 비트;

import java.util.Scanner;

public class boj1052_물병 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        int num = N;
        while (Integer.bitCount(num) > K)
            num++;

        System.out.println(num - N);
    }
}
