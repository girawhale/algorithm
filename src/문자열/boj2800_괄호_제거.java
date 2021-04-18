package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2800_괄호_제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> print = new HashSet<>();
        int count = (int) str.chars().filter(c -> c == '(').count();

        for (int i = 1; i < (1 << count); i++) {
            StringBuilder sb = new StringBuilder();
            Deque<Integer> stack = new ArrayDeque<>();

            int idx = 0;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '(') {
                    stack.push(idx);
                    if ((i & (1 << idx++)) != 0) continue;
                }
                if (ch == ')' && (i & (1 << stack.pop())) != 0) continue;

                sb.append(ch);
            }
            print.add(sb.toString());
        }

        print.stream().sorted().forEach(System.out::println);
    }
}