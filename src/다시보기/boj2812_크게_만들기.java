package 다시보기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class boj2812_크게_만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String num = sc.next();

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (K > 0 && !stack.isEmpty() && stack.peek() < ch) {
                stack.pop();
                K--;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (K < stack.size() && !stack.isEmpty())
            sb.append(stack.pollLast());
        System.out.println(sb);
    }

}
