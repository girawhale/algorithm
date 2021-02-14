package 시뮬레이션;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class prog42891_무지의_먹방_라이브 {
    public int solution(int[] food_times, long k) {
        List<Food> foods = IntStream.range(0, food_times.length)
                .mapToObj(i -> new Food(i + 1, food_times[i]))
                .sorted(Comparator.comparing(f -> f.time)).collect(Collectors.toList());

        long prev = 0;
        int idx = 0;
        while (idx < foods.size()) {
            long min = foods.get(idx).time - prev;

            if (min * (foods.size() - idx) > k) break;
            k -= min * (foods.size() - idx);

            prev += min;
            idx++;
        }

        long finalPrev = prev;
        foods = foods.stream().filter(f -> f.time > finalPrev)
                .sorted(Comparator.comparingInt(f -> f.idx)).collect(Collectors.toList());
        return idx == foods.size() ? -1 : foods.get((int) (k % foods.size())).idx;
    }

    class Food {
        int idx, time;

        Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}