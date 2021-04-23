package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5875_오타 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = br.readLine().chars().map(i -> i == '(' ? 1 : -1).toArray();

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
            if (isCorrect(arr)) ans++;
            arr[i] = -arr[i];
        }
        System.out.println(ans);

    }

    public static boolean isCorrect(int[] arr) {
        int sum = 0;

        for (int num : arr) {
            if ((sum += num) < 0)
                return false;
        }

        return sum == 0;
    }
}
