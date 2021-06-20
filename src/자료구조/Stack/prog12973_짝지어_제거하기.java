package 자료구조.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class prog12973_짝지어_제거하기 {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
