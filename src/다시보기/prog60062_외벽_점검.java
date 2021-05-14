package 다시보기;

import java.util.ArrayList;

public class prog60062_외벽_점검 {
    int n, distLen, weakLen;
    ArrayList<ArrayList<Integer>> perm = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        distLen = dist.length;
        weakLen = weak.length;
        int answer = Integer.MAX_VALUE;

        int[] weakList = new int[weakLen * 2];
        for (int i = 0; i < weakLen; i++) {
            weakList[i] = weak[i];
            weakList[i + weakLen] = weak[i] + n;
        }

        permutation(new int[distLen], new boolean[distLen], 0, distLen);

        for (int start = 0; start < weakLen; start++) {
            for (ArrayList<Integer> list : perm) {
                int cnt = 1;
                int pos = weakList[start] + dist[list.get(0)];

                for (int i = start; i < start + weakLen; i++) {
                    if (pos < weakList[i]) {
                        if (++cnt > distLen) break;

                        pos = weakList[i] + dist[list.get(cnt - 1)];
                    }
                }
                System.out.println(list + " " + cnt);

                answer = Math.min(answer, cnt);
            }
        }

        System.out.println(answer);
        return answer >= distLen ? -1 : answer;
    }

    public void permutation(int[] ret, boolean[] visit, int cnt, int depth) {
        if (cnt == depth) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int r : ret)
                tmp.add(r);

            perm.add(tmp);
            return;
        }

        for (int i = 0; i < distLen; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            ret[cnt] = i;
            permutation(ret, visit, cnt + 1, depth);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
//        new 다시보기.prog60062_외벽_점검().solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4});
        new prog60062_외벽_점검().solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7});
    }
}
