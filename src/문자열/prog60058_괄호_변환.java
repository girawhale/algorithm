package 문자열;

public class prog60058_괄호_변환 {
    public String solution(String p) {
        return solve(p);
    }

    String solve(String s) {
        if (s.length() == 0) return s;

        int idx = 0, cnt = 0;
        for (; idx < s.length(); idx++) {
            cnt += s.charAt(idx) == '(' ? 1 : -1;
            if (cnt == 0) break;
        }
        String u = s.substring(0, ++idx), v = solve(s.substring(idx));

        if (check(u)) return u + v;
        else
            return "(" + v + ")" +
                    u.substring(1, u.length() - 1).chars()
                            .mapToObj(i -> i == '(' ? ')' : '(')
                            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }

    boolean check(String str) {
        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') cnt++;
            else if (--cnt < 0) return false;
        }
        return true;
    }
}
