package 투포인터;

import java.util.Scanner;

public class boj6137_문자열_생성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) arr[i] = sc.next().charAt(0);

        int left = 0, right = N - 1, len = 0;
        StringBuilder sb = new StringBuilder();

        while (left <= right) {
            if (arr[left] < arr[right]) {
                sb.append(arr[left++]);
            } else if ((arr[left] > arr[right])) {
                sb.append(arr[right--]);
            } else {
                int l = left + 1;
                int r = right - 1;

                while ((l < r) && (arr[l] == arr[r])) {
                    l++;
                    r--;
                }
                if (arr[l] < arr[r]) {
                    sb.append(arr[left++]);
                } else {
                    sb.append(arr[right--]);
                }
            }
            if (++len % 80 == 0) sb.append('\n');
        }

        System.out.println(sb);
    }
}
