package 문자열;

public class prog60057_문자열_압축 {
    public int solution(String str) {
        int min = str.length();

        for (int s = 1; s <= str.length() / 2; s++) {
            String prev;
            int idx = 0, cnt = 0, len = 0;

            for (; idx + s <= str.length(); cnt = 0) {
                prev = str.substring(idx, idx + s);
                while (idx + s <= str.length() && prev.equals(str.substring(idx, idx + s))) {
                    cnt++;
                    idx += s;
                }
                len += s + (cnt == 1 ? 0 : Math.log10(cnt) + 1);
            }
            min = Math.min(len + str.length() % s, min);
        }
        return min;
    }
}
