package 구현;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class prog68646_풍선_터트리기 {
    public int solution(int[] a) {
        int n = a.length;
        int[] left = new int[n];
        left[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
            left[i] = Math.min(left[i - 1], a[i - 1]);

        int[] right = new int[n];
        right[n - 1] = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.min(right[i + 1], a[i + 1]);

        return (int) IntStream.range(0, n).filter(i -> !(left[i] < a[i] && right[i] < a[i])).count();
    }

    public int solution2(int[] a) {
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        int leftMin = a[0], rightMin = a[n - 1];

        for (int i = 0; i < n; i++) set.add(leftMin = Math.min(leftMin, a[i]));
        for (int i = n - 1; i >= 0; i--) set.add(rightMin = Math.min(rightMin, a[i]));

        return set.size();
    }
}
