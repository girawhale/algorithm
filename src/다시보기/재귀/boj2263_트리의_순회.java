package 다시보기.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2263_트리의_순회 {
    static int[] inOrder, postOrder, idx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        idx = new int[N + 1];
        for (int i = 0; i < N; i++) idx[inOrder[i]] = i;

        solve(0, N - 1, 0, N - 1);
        System.out.println(sb.toString());
    }

    static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postOrder[postEnd];
        sb.append(root).append(' ');

        int left = idx[root] - inStart;
        solve(inStart, idx[root] - 1, postStart, postStart + left - 1);
        solve(idx[root] + 1, inEnd, postStart + left, postEnd - 1);
    }
}
