package 이분탐색;

import java.util.*;

public class prog60060_가사_검색 {
    public List<Integer> solution(String[] words, String[] queries) {
        Map<Integer, List<String>> frontMap = new HashMap<>();
        Map<Integer, List<String>> backMap = new HashMap<>();

        for (String word : words) {
            int len = word.length();

            frontMap.computeIfAbsent(len, i -> new ArrayList<>()).add(word);
            backMap.computeIfAbsent(len, i -> new ArrayList<>()).add(reverse(word));
        }

        for (int key : frontMap.keySet()) {
            frontMap.get(key).sort(null);
            backMap.get(key).sort(null);
        }

        List<Integer> ans = new ArrayList<>();
        for (String query : queries) {
            List<String> list;
            if (query.charAt(0) == '?') {
                list = backMap.get(query.length());
                query = reverse(query);
            } else
                list = frontMap.get(query.length());

            if (list == null) ans.add(0);
            else ans.add(lowerBound(list, query.replace('?', Character.MAX_VALUE))
                    - lowerBound(list, query.replace("?", "")));
        }

        return ans;
    }

    int lowerBound(List<String> list, String str) {
        int s = 0, e = list.size();

        while (s < e) {
            int m = (s + e) / 2;

            if (str.compareTo(list.get(m)) <= 0)
                e = m;
            else s = m + 1;
        }

        return s;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
