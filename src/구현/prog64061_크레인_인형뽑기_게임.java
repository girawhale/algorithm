package 구현;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class prog64061_크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        int[] top = new int[N];
        for (int i = 0; i < N; i++) {
            int idx = 0;
            while (idx < N && board[idx][i] == 0)
                idx++;
            top[i] = idx;
        }

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int move : moves) {
            if (move >= N) continue;
            int tmp = board[top[move - 1]++][move - 1];

            if (stack.isEmpty() || stack.peek() != tmp)
                stack.push(tmp);
            else {
                stack.pop();
                ans += 2;
            }
        }

        return ans;
    }
}
