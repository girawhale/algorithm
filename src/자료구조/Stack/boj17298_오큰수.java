package 자료구조.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class boj17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : A[stack.peek()];
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(ans).forEach(i -> sb.append(i).append(' '));
        System.out.println(sb);
    }
}
