import java.util.*;

public class prog60060_가사_검색 {
    class Trie {
        Map<Integer, Integer> lenMap = new HashMap<>();
        Trie[] child = new Trie[26];

        void insert(String str) {
            Trie node = this;
            int len = str.length();
            lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';
                if (node.child[idx] == null)
                    node.child[idx] = new Trie();

                node = node.child[idx];
                node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
            }
        }

        int find(String str, int i) {
            if (str.charAt(i) == '?')
                return lenMap.getOrDefault(str.length(), 0);

            int idx = str.charAt(i) - 'a';
            return child[idx] == null ? 0 : child[idx].find(str, i + 1);
        }

    }

    public int[] solution(String[] words, String[] queries) {
        Trie front = new Trie();
        Trie back = new Trie();

        for (String word : words) {
            front.insert(word);
            back.insert(new StringBuilder(word).reverse().toString());
        }

        return Arrays.stream(queries).mapToInt(
                query -> query.charAt(0) == '?' ?
                        back.find(new StringBuilder(query).reverse().toString(), 0) :
                        front.find(query, 0)).toArray();
    }

    // 정확성: 25.0 (18/18)
    // 효율성: 30.0 (2/5)
    // 합계: 55.0 / 100.0
    public int[] solution2(String[] words, String[] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String replaceQuery = queries[i].replace('?', '.');
            for (String word : words) {
                if (word.matches(replaceQuery)) ans[i]++;
            }
        }

        return ans;
    }
}
