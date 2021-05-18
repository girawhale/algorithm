package 다시보기.정렬;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj1599_민식어 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        RuleBasedCollator col = new RuleBasedCollator("<a <b <k <d <e <g <h <i <l <m <n <ng <o <p <r <s <t <u <w <y");

        IntStream.range(0, N)
                .mapToObj(i -> sc.next())
                .sorted(col::compare)
                .forEach(System.out::println);
    }
}
