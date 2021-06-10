package 구현;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class prog42579_베스트앨범 {
    class Music {
        int idx, playCnt;
        String genre;

        public Music(int idx, int playCnt, String genre) {
            this.idx = idx;
            this.playCnt = playCnt;
            this.genre = genre;
        }

        int getIdx() {
            return idx;
        }

        int getPlayCnt() {
            return playCnt;
        }

        String getGenre() {
            return genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(i, plays[i], genres[i]))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted(comparingInt(g ->
                        -g.getValue().stream().mapToInt(Music::getPlayCnt).sum()))
                .flatMap(v ->
                        v.getValue().stream()
                                .sorted(comparingInt(Music::getPlayCnt).reversed()
                                        .thenComparingInt(Music::getIdx)).limit(2))
                .mapToInt(Music::getIdx)
                .toArray();
    }
}
