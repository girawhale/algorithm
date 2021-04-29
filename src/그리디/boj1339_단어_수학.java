package 그리디;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1339_단어_수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] count = new int[26];

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            int len = word.length();

            IntStream.range(0, len).forEach(j -> count[word.charAt(j) - 'A'] += (int) Math.pow(10, len - j - 1));
        }
        Arrays.sort(count);

        int sum = IntStream.range(0, 10).reduce(0, (s, i) -> s + count[25 - i] * (9 - i));
        System.out.println(sum);
    }
}
