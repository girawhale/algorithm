package 정렬;

import java.util.*;

public class boj1717_후보_추천하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int[] idx = new int[1000];
        Arrays.fill(idx, -1);

        for (int i = 0; i < M; i++) {
            int num = sc.nextInt();

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                if (map.size() == N) {
                    ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
                    entries.sort(Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
                            .thenComparingInt(e -> idx[e.getKey()]));

                    Integer remove = entries.get(0).getKey();
                    map.remove(remove);
                    idx[remove] = -1;
                }
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (idx[num] == -1) idx[num] = i;
            }
        }

        map.keySet().stream().sorted().forEach(k -> System.out.print(k + " "));
    }
}
