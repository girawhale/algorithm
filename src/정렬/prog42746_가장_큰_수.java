package 정렬;

import java.util.Arrays;

public class prog42746_가장_큰_수 {
    public String solution(int[] numbers) {
        String str = Arrays.stream(numbers).mapToObj(Integer::toString)
                .sorted((o1, o2) -> {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;

                    return s2.compareTo(s1);
                }).reduce((ret, s) -> ret + s).get();
        return str.charAt(0) == 0 ? "0" : str;
    }
}
