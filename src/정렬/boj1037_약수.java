package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class boj1037_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

        Arrays.sort(nums);
        System.out.println(N % 2 == 0 ? nums[0] * nums[N - 1] : nums[N / 2] * nums[N / 2]);
    }
}
