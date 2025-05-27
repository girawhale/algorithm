package 정렬;

import java.util.*;

public class leetcode57_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int idx = 0;
        boolean flag = false;
        while (idx < intervals.length) {
            if ((intervals[idx][0] <= newInterval[0] && newInterval[0] <= intervals[idx][1]) ||
                    (newInterval[0] <= intervals[idx][0] && intervals[idx][0] <= newInterval[1])) {
                int start = Math.min(intervals[idx][0], newInterval[0]);
                int end = Math.max(intervals[idx++][1], newInterval[1]);

                while (idx < intervals.length && end >= intervals[idx][0]) {
                    end = Math.max(end, intervals[idx++][1]);
                }
                res.add(new int[]{start, end});
                flag = true;
                continue;
            }
            res.add(intervals[idx++]);
        }

        if (!flag) {
            res.add(newInterval);
            res.sort(Comparator.comparingInt(o -> o[0]));
        }


        return res.toArray(new int[res.size()][]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int idx = 0;

        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(intervals[idx++]);
        }

        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        res.add(newInterval);

        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}