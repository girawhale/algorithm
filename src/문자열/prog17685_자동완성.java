package 문자열;

import java.util.Arrays;

public class prog17685_자동완성 {
    public int solution(String[] words) {
        int ans = 0;

        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            int prev = i == 0 ? 0 : typingCnt(words[i], words[i - 1]);
            int next = i == words.length - 1 ? 0 : typingCnt(words[i], words[i + 1]);

            ans += Math.max(prev, next);
        }
        return ans;
    }

    public int typingCnt(String base, String compare) {
        int len = Math.min(base.length(), compare.length());
        for (int i = 0; i < len; i++) {
            if (base.charAt(i) != compare.charAt(i))
                return i + 1;
        }
        return base.length() > compare.length() ? len + 1 : len;
    }
}
