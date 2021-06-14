package 정렬;

import java.util.stream.IntStream;

public class prog42748_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        return IntStream.range(0, commands.length)
                .map(i -> IntStream.range(commands[i][0] - 1, commands[i][1])
                        .map(j -> array[j]).sorted()
                        .toArray()[commands[i][2] - 1])
                .toArray();
    }
}
