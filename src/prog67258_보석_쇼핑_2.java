import java.util.*;

public class prog67258_보석_쇼핑_2 {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int len = Integer.MAX_VALUE, start = 0;

        set.addAll(Arrays.asList(gems));

        int s = 0, e = 0;
        while (true) {
            if (map.size() == set.size()) {
                if (len > e - s) {
                    start = s + 1;
                    len = e - s;
                }
                if (map.get(gems[s]) == 1)
                    map.remove(gems[s]);
                else map.put(gems[s], map.get(gems[s]) - 1);
                s++;
            } else if (e < gems.length)
                map.put(gems[e], map.getOrDefault(gems[e++], 0) + 1);
            else break;
        }

        return new int[]{start, start + len - 1};
    }

    public static void main(String[] args) {
        new prog67258_보석_쇼핑_2().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        new prog67258_보석_쇼핑_2().solution(new String[]{"XYZ", "XYZ", "XYZ"});
        new prog67258_보석_쇼핑_2().solution(new String[]{"DIA", "EM", "EM", "RUB", "DIA"});
    }
}
