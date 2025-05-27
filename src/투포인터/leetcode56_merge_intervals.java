package 투포인터;

import java.util.*;

public class leetcode56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        final List<int[]> res = new ArrayList<>();

        int start = intervals[0][0], end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        leetcode56_merge_intervals sol = new leetcode56_merge_intervals();

        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = sol.merge(input);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
        // 출력: [1,6], [8,10], [15,18]
    }
}