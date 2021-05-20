package 정렬;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1599_민식어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        IntStream.range(0, N)
                .mapToObj(i -> sc.next())
                .sorted(Comparator.comparing(s -> s.replace('k', 'c').replace("ng", "n~")))
                .forEach(System.out::println);
    }
}
