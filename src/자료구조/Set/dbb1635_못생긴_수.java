package 자료구조.Set;

import java.util.Scanner;
import java.util.TreeSet;

public class dbb1635_못생긴_수 { // http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=597
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Long> queue = new TreeSet<>();
        long[] memo = new long[1501];
        queue.add(1L);

        for (int i = 1; i <= 1500; i++) {
            memo[i] = queue.pollFirst();

            queue.add(memo[i] * 2);
            queue.add(memo[i] * 3);
            queue.add(memo[i] * 5);
        }

        int N;
        while ((N = sc.nextInt()) != 0)
            System.out.println(memo[N]);

    }

}
