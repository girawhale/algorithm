package 정렬;

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj2750_수_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (N-- > 0)
            queue.add(sc.nextInt());

        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
