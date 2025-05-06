package 문자열;

import java.util.*;

public class leetcode68_text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();

        List<String> cur = new ArrayList<>();
        int i = 0, len = 0;
        while (i < words.length) {
            String word = words[i];
            if (len + word.length() < maxWidth) {
                cur.add(word);
                len += word.length() + 1;
                i++;
            } else if (cur.size() > 1) {
                int space = maxWidth - len + cur.size();
                int sp = space / (cur.size() - 1);
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < cur.size() - 1; j++) {
                    str.append(cur.get(j));
                    String tempSpace = (cur.size() - j - 1) * sp < space ? " ".repeat(sp + 1) : " ".repeat(sp);
                    str.append(tempSpace);
                    space -= tempSpace.length();
                }
                str.append(cur.getLast());
                ret.add(str.toString());

                len = 0;
                cur.clear();
            } else {
                String s = cur.get(0);
                ret.add(s + " ".repeat(maxWidth - s.length()));

                len = 0;
                cur.clear();
            }
        }

        if (!cur.isEmpty()) {
            String joined = String.join(" ", cur);
            if (joined.length() < maxWidth)
                joined += " ".repeat(maxWidth - joined.length());
            ret.add(joined);
        }

        return ret;
    }
}