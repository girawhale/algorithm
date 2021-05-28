package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21774_가희와_로그_파일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<String>[] timeList = new ArrayList[7];
        for (int i = 1; i <= 6; i++) timeList[i] = new ArrayList<>();

        while (N-- > 0) {
            String[] input = br.readLine().split("#");
            int level = Integer.parseInt(input[1]);
            timeList[level].add(input[0]);
        }

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            String[] input = br.readLine().split("#");
            int level = Integer.parseInt(input[2]);

            int cnt = 0;
            for (int l = level; l <= 6; l++) {
                cnt += (lowerBound(timeList[l], input[1] + "0") - lowerBound(timeList[l], input[0]));
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static int lowerBound(List<String> list, String time) {
        int start = 0, end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (list.get(mid).compareTo(time) < 0)
                start = mid + 1;
            else end = mid;
        }

        return end;
    }

}