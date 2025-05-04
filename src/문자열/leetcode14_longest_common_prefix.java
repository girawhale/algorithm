package 문자열;

public class leetcode14_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        String str = strs[0];

        for (int i = 0; i < str.length(); i++) {
            boolean flag = true;
            char c = str.charAt(i);

            for (String s : strs) {
                if (s.length() <= i || c != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prefix += c;
            } else {
                break;
            }
        }

        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}