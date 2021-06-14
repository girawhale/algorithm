package DFS;

import java.util.HashMap;
import java.util.Map;

public class prog1835_단체사진_찍기 {
    int[] select = new int[8];
    boolean[] used = new boolean[8];
    Map<Character, Integer> map = new HashMap<>();

    public int solution(int n, String[] data) {
        String friends = "ACFJMNRT";
        for (int i = 0; i < 8; i++) map.put(friends.charAt(i), i);

        return dfs(0, data);
    }

    int dfs(int idx, String[] data) {
        if (idx == 8) {
            for (String d : data) {
                int dist = Math.abs(select[map.get(d.charAt(0))] - select[map.get(d.charAt(2))]) - 1;
                char op = d.charAt(3);
                int num = d.charAt(4) - '0';

                if (op == '<' && dist >= num || op == '>' && dist <= num
                        || op == '=' && dist != num) return 0;
            }
            return 1;
        }

        int ret = 0;
        for (int i = 0; i < 8; i++) {
            if (used[i]) continue;

            select[idx] = i;
            used[i] = true;
            ret += dfs(idx + 1, data);
            used[i] = false;
        }
        return ret;
    }
}
