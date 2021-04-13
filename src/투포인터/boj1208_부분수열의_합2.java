package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj1208_부분수열의_합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        comb(arr, list1, 0, N / 2, 0);
        comb(arr, list2, N / 2, N, 0);

        list1.sort(null);
        list2.sort(null);

        long ans = 0;
        int idx1 = 0, idx2 = list2.size() - 1;

        while (idx1 < list1.size() && idx2 >= 0) {
            int n1 = list1.get(idx1);
            int n2 = list2.get(idx2);

            if (n1 + n2 == S) {
                int cnt1 = 0, cnt2 = 0;

                while (idx1 < list1.size() && list1.get(idx1) == n1) {
                    cnt1++;
                    idx1++;
                }

                while (idx2 >= 0 && list2.get(idx2) == n2) {
                    cnt2++;
                    idx2--;
                }

                ans += (long) cnt1 * cnt2;

            } else if (n1 + n2 < S) idx1++;
            else idx2--;
        }
        System.out.println(list1.size());
        if (S == 0) ans--;
        System.out.println(ans);
    }

    static void comb(int[] arr, List<Integer> list, int idx, int to, int num) {
        if (to == idx) {
            list.add(num);
            return;
        }

        comb(arr, list, idx + 1, to, num);
        comb(arr, list, idx + 1, to, num + arr[idx]);
    }
}
