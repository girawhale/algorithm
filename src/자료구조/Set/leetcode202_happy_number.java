package 자료구조.Set;

import java.util.HashSet;
import java.util.Set;

public class leetcode202_happy_number {
    public boolean isHappy(int n) {
        Set<Integer> used = new HashSet<>();

        while (n > 1 && !used.contains(n)) {
            used.add(n);

            int num = n, total = 0;
            while (num > 0) {
                int temp = num % 10;
                total += Math.pow(temp, 2);
                num /= 10;
            }
            n = total;
        }

        return n == 1;
    }
}