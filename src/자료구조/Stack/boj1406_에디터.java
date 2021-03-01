package 자료구조.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> wait = new ArrayDeque<>();

        for (char c : str.toCharArray()) stack.push(c);

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);

            if (op == 'L') {
                if (!stack.isEmpty()) wait.push(stack.pop());
            } else if (op == 'D') {
                if (!wait.isEmpty()) stack.push(wait.pop());
            } else if (op == 'B') {
                if (!stack.isEmpty()) stack.pop();
            } else
                stack.push(st.nextToken().charAt(0));
        }


        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pollLast());
        while (!wait.isEmpty()) sb.append(wait.pop());
        System.out.println(sb.toString());
    }
}
