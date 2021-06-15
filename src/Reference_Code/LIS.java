package Reference_Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
    public int N2(int[] arr) {
        int N = arr.length;
        int[] cnt = new int[N];

        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && cnt[i] < cnt[j] + arr[i]) {
                    cnt[i] = cnt[j] + arr[i];
                }
            }

            max = Math.max(max, cnt[i]);
        }
        return max;
    }

    public int logN(int[] arr) {
        int N = arr.length;

        List<Integer> list = new ArrayList<>();
        int[] cnt = new int[N];

        list.add(arr[0]);
        cnt[0] = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] <= list.get(list.size() - 1)) {
                int idx = Collections.binarySearch(list, arr[i]);

                if (idx >= 0) {
                    cnt[i] = idx + 1;
                } else {
                    idx = -idx - 1;
                    list.set(idx, arr[i]);
                    cnt[i] = idx + 1;
                }
            } else {
                list.add(arr[i]);
                cnt[i] = list.size();
            }
        }

        return list.size();
    }
}
