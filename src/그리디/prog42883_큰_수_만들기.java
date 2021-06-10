package 그리디;

import java.util.ArrayDeque;
import java.util.Deque;

public class prog42883_큰_수_만들기 {
    public String solution(String number, int k) {
        int len = number.length() - k;
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().substring(0, len);
    }
}
