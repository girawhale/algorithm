package 문자열;

import java.util.Arrays;

public class leetcode242_valid_anagram {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        return Arrays.stream(counts).allMatch(count -> count == 0);
    }

    public static void main(String[] args) {
        leetcode242_valid_anagram sol = new leetcode242_valid_anagram();

        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "car"));          // false
    }
}