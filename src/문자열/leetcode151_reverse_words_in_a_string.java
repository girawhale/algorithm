package 문자열;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode151_reverse_words_in_a_string {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
