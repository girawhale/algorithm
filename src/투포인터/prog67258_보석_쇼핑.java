package 투포인터;

import java.util.*;

public class prog67258_보석_쇼핑 {
    public int[] solution(String[] gems) {
        int N = (int) Arrays.stream(gems).distinct().count();

        Map<String, Integer> map = new HashMap<>();
        int start = 0, len = Integer.MAX_VALUE;

        int idx = 0;
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            while (map.get(gems[idx]) > 1) {
                map.put(gems[i], map.get(gems[idx]) - 1);
                idx++;
            }

            if (map.size() == N && i - idx < len) {
                len = i - idx;
                start = idx + 1;
            }
        }

        return new int[]{start, start + len};
    }
}
