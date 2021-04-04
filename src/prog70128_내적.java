import java.util.stream.IntStream;

public class prog70128_내적 {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
