package 구현;

import java.util.Arrays;

public class prog77484_로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = (int) Arrays.stream(lottos).filter(i -> i == 0).count();
        int count = (int) Arrays.stream(lottos).filter(l -> Arrays.stream(win_nums).anyMatch(w -> l == w)).count();

        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        return new int[]{rank[count + zero], rank[count]};
    }
}
