package 다시보기.DFS;

import java.util.stream.IntStream;

public class prog43163_단어_변환 {
    boolean[] visit;
    int ans = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];

        dfs(begin, target, words, 0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    void dfs(String str, String target, String[] words, int cnt) {
        if (cnt > ans) return;
        if (str.equals(target)) {
            ans = cnt;
        }

        for (int i = 0; i < words.length; i++) {
            if (visit[i] || diffCount(str, words[i]) != 1) continue;

            visit[i] = true;
            dfs(words[i], target, words, cnt + 1);
            visit[i] = false;
        }
    }

    int diffCount(String str1, String str2) {
        return (int) IntStream.range(0, str1.length())
                .filter(i -> str1.charAt(i) != str2.charAt(i))
                .count();
    }
}
