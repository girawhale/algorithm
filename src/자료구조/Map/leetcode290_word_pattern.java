package 자료구조.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode290_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = strings[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(str)) return false;
                continue;
            }
            if (set.contains(str)) {
                return false;
            }
            map.put(c, str);
            set.add(str);
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode290_word_pattern sol = new leetcode290_word_pattern();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println(sol.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(sol.wordPattern("abba", "dog dog dog dog"));  // false
    }
}