package 자료구조.Map;

import java.util.Map;

public class leetcode13_roman_to_integer {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int length = s.length();
        int ret = map.get(s.charAt(length - 1));

        for (int i = 0; i < length - 1; i++) {
            int cur = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));

            ret += cur >= next ? cur : -cur;
        }

        return ret;
    }
}