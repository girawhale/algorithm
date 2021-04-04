package 문자열;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class prog64064_불량_사용자 {
    Set<Integer> set = new HashSet<>();
    String[] banPatterns;

    public int solution(String[] user_id, String[] banned_id) {
        banPatterns = Arrays.stream(banned_id)
                .map(b -> b.replace("*", ".")).toArray(String[]::new);

        solve(0,0,user_id);
        return set.size();
    }

    void solve(int idx, int visit, String[] userId) {
        if (idx == banPatterns.length) {
            set.add(visit);
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if ((visit & (1 << i)) > 0 || !userId[i].matches(banPatterns[idx])) continue;

            solve(idx + 1, visit | (1 << i), userId);
        }
    }
}
