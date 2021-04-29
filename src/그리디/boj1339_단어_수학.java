package 그리디;

import java.util.*;
import java.util.stream.IntStream;

public class boj1339_단어_수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = IntStream.range(0, N).mapToObj(i -> sc.next()).toArray(String[]::new);
        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + (int) Math.pow(10, len - i - 1));
            }
        }
        List<Character> chList = new ArrayList<>(map.keySet());
        chList.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));

        int sum = 0;
        for (String word : words) {
            sum += word.chars().reduce(0, (s, ch) -> s * 10 + (9 - chList.indexOf((char) ch)));
        }

        System.out.println(sum);
    }
}
