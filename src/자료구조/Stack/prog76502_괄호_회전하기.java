package 자료구조.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class prog76502_괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            stack.clear();

            if (solve(s, stack)) answer++;
        }

        return answer;
    }

    private boolean solve(String s, Deque<Character> stack) {
        for (char ch : s.toCharArray()) {
            if ("({[".indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch - stack.peek() > 2) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new prog76502_괄호_회전하기().solution("}]()[{"));
    }
}
