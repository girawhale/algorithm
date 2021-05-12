package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int[] group = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                group[arr[i - 1] - '0']++;
            }
        }
        group[arr[arr.length - 1] - '0']++;

        System.out.println(Math.min(group[0], group[1]));
    }
}
