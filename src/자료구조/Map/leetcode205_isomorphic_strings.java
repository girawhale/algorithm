package 자료구조.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode205_isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c)) {
                if (set.contains(c2)) return false;
                map.put(c, c2);
                set.add(c2);
                continue;
            }

            Character matched = map.get(c);
            if (matched != c2) return false;
        }

        return true;
    }
}