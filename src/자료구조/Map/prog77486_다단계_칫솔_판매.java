package 자료구조.Map;

import java.util.HashMap;
import java.util.Map;

public class prog77486_다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        Map<String, Integer> enrollIdx = new HashMap<>();

        for (int i = 0; i < N; i++) enrollIdx.put(enroll[i], i);

        int[] ans = new int[N];
        for (int i = 0; i < seller.length; i++) {
            int idx = enrollIdx.get(seller[i]);
            int money = amount[i] * 100;

            while (true) {
                int send = (int) (money * 0.1);
                ans[idx] += money - send;
                money = send;

                if (!enrollIdx.containsKey(referral[idx]) || money == 0) break;
                idx = enrollIdx.get(referral[idx]);
            }
        }

        return ans;
    }
}
