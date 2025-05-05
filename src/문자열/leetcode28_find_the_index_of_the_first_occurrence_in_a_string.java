package 문자열;

public class leetcode28_find_the_index_of_the_first_occurrence_in_a_string {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStrWithWindow(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}