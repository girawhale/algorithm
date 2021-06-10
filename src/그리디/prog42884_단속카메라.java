package 그리디;

import java.util.Arrays;
import java.util.Comparator;

public class prog42884_단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int ans = 0;
        int prev = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (prev < route[0]) {
                prev = route[1];
                ans++;
            }
        }

        return ans;
    }
}
