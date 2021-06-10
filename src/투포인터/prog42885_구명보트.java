package 투포인터;

import java.util.Arrays;

public class prog42885_구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1;
        int ans = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            ans++;
        }

        return ans;
    }
}
