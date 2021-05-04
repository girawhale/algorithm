package 구현;

import java.util.Scanner;

public class boj15905_스텔라가_치킨을_선물했어요 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 100_000;
        int N = sc.nextInt();
        int[] arr = new int[MAX + 1];

        while (N-- > 0) {
            arr[sc.nextInt()]++;
            sc.nextInt();
        }

        int sum = 0;
        for (int i = MAX; i > 0; i--) {
            sum += arr[i];
            if (sum >= 5) {
                System.out.println(sum - 5);
                return;
            }
        }

    }
}
