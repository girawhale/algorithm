package 자료구조.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class boj2075_N번째_큰_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        IntStream.range(0, N * N).forEach(i -> queue.add(sc.nextInt()));
        IntStream.range(0, N - 1).forEach(i -> queue.poll());

        System.out.println(queue.peek());
    }
}
