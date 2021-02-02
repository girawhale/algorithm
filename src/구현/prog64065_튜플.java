package 구현;

import java.util.*;

public class prog64065_튜플 {
    public int[] solution(String s) {
        String[] tuples = Arrays.stream(s.replaceAll("\\{\\{|}}", "").split("},\\{"))
                .sorted(Comparator.comparingInt(String::length)).toArray(size -> new String[size]);

        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (String tuple : tuples) {
            int[] nums = Arrays.stream(tuple.split(",")).mapToInt(Integer::parseInt).toArray();

            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                    ans.add(num);
                }
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        new prog64065_튜플().solution("{{123}}");
    }
}
