package 구현.소수;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class prog42839_소수_찾기 {
    Set<Integer> set = new HashSet<>();
    boolean[] prime = new boolean[(int) 1e8];
    boolean[] visit;

    public int solution(String numbers) {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i < 1e8; i++) {
            for (int j = i * i; j < 1e8; j += i)
                prime[j] = false;
        }
        visit = new boolean[numbers.length()];

        solve(0, 0, numbers);
        return set.size();
    }

    public void solve(int num, int idx, String numbers) {
        if (prime[num]) set.add(num);
        if (idx == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (visit[i]) continue;

            visit[i] = true;
            solve(num * 10 + (numbers.charAt(i) - '0'), idx + 1, numbers);
            visit[i] = false;
        }
    }
}
