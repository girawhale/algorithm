package 자료구조.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class boj2257_화학식량 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();

        map.put('(', -1);
        map.put('H', 1);
        map.put('C', 12);
        map.put('O', 16);

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(stack.pop() * (ch - '0'));
            } else if (ch == ')') {
                int sum = 0;
                while (stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop();

                stack.push(sum);
            } else {
                stack.push(map.get(ch));
            }
        }
        System.out.println(stack.stream().mapToInt(i -> i).sum());
    }
}
