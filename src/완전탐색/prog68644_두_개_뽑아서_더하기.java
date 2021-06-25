package 완전탐색;

import java.util.stream.IntStream;

public class prog68644_두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .flatMap(i ->
                        IntStream.range(i, numbers.length)
                                .map(j -> numbers[i] + numbers[j]))
                .distinct().sorted().toArray();
    }
}
