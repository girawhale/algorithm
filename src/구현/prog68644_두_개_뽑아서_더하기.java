package 구현;

import java.util.TreeSet;

public class prog68644_두_개_뽑아서_더하기 {
    public Integer[] solution(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++)
            for (int j = i + 1; j < numbers.length; j++)
                set.add(numbers[i] + numbers[j]);

        return set.toArray(new Integer[0]);
    }
}
