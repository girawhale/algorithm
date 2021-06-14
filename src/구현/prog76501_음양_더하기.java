package 구현;

import java.util.stream.IntStream;

public class prog76501_음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, signs.length)
                .reduce(0, (s, i) -> s += signs[i] ? absolutes[i] : -absolutes[i]);
    }
}
