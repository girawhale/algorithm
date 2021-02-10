package 구현;

import java.util.Arrays;

public class prog42899_실패율 {
    public int[] solution(int N, int[] stages) {
        Stage[] arr = new Stage[N];
        for (int i = 0; i < N; i++) arr[i] = new Stage(i + 1);

        for (int stage : stages) {
            arr[Math.min(stage, N) - 1].count++;
            if (stage != N + 1) arr[stage - 1].fail++;
        }
        for (int i = N - 1; i > 0; i--)
            arr[i - 1].count += arr[i].count;

        return Arrays.stream(arr).sorted().mapToInt(s -> s.num).toArray();
    }

    class Stage implements Comparable<Stage> {
        int num, count, fail;

        Stage(int num) {
            this.num = num;
        }

        double failRate() {
            return count == 0 ? 0 : (double) fail / count;
        }

        @Override
        public int compareTo(Stage o) {
            return this.failRate() != o.failRate() ?
                    Double.compare(o.failRate(), this.failRate())
                    : Integer.compare(this.num, o.num);
        }
    }
}
