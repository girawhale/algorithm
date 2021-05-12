package 그리디;

import java.util.Scanner;
import java.util.stream.IntStream;

public class boj2437_저울 { //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = IntStream.range(0, N).map(i -> sc.nextInt()).sorted().toArray();

        int sum = 1;
        for (int i = 0; i < N; i++) {
            if (sum < arr[i]) break;
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
