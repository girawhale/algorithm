package 자료구조.Map;

import java.util.HashMap;
import java.util.Map;

public class leetcode3_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, leftIdx = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && map.get(c) >= leftIdx) {
                leftIdx = map.get(c) + 1;
            }
            max = Math.max(max, i - leftIdx + 1);
            map.put(c, i);
        }

        return max;
    }
}