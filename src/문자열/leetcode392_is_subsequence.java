package 문자열;

public class leetcode392_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int cnt = 0;

        for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                cnt++;
                i++;
            }
        }

        return cnt == s.length();
    }
}