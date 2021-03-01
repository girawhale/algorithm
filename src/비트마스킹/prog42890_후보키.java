package 비트마스킹;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class prog42890_후보키 {
    List<Integer> key = new ArrayList<>();

    boolean ckMinimality(int i) {
        for (int k : key)
            if ((k & i) == k) return false;
        return true;
    }

    public int solution(String[][] relation) {
        int n = relation.length, m = relation[0].length;

        for (int k = 1; k < (1 << m); k++) {
            if (!ckMinimality(k)) continue;

            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                StringBuilder key = new StringBuilder();

                for (int j = 0; j < m; j++) {
                    if (((1 << j) & k) > 0) key.append(relation[i][j]).append('/');
                }

                if (!set.add(key.toString())) break;
            }
            if (set.size() == n) key.add(k);
        }
        return key.size();
    }
}
