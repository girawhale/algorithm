package 문자열;

import java.util.*;

public class boj20437_문자열_게임_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            char[] arr = sc.next().toCharArray();
            int K = sc.nextInt();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                List<Integer> list = map.computeIfAbsent(arr[i], c -> new ArrayList<>());
                list.add(i);

                if (list.size() >= K) {
                    int tmp = list.get(list.size() - 1) - list.get(list.size() - K) + 1;
                    min = Math.min(min, tmp);
                    max = Math.max(max, tmp);
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
