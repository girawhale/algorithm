import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class prog42891_무지의_먹방_라이브 {
    public int solution(int[] food_times, long k) {
        List<Food> foods = IntStream.range(0, food_times.length).mapToObj(i -> new Food(i + 1, food_times[i]))
                .sorted().collect(Collectors.toList());

        int t = 0;
        while (true) {

            break;
        }

        while (foods.size() > 0) {
            long min = foods.stream().min(Comparator.comparing(f -> f.time)).get().time;

            if (min * foods.size() > k) break;

            k -= min * foods.size();

            foods = foods.stream().filter(food -> food.time > min).collect(Collectors.toList());
            foods.forEach(food -> food.eat(min));
        }

        return foods.size() == 0 ? -1 : foods.get((int) (k % foods.size())).idx;
    }

    class Food implements Comparable<Food> {
        int idx, time;

        Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        void eat(long t) {
            this.time -= t;
        }

        @Override
        public int compareTo(Food o) {
            return this.time != o.time ? Integer.compare(this.time, o.time) : Integer.compare(this.idx, o.idx);
        }
    }
}