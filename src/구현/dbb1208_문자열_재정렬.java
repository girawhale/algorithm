package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class dbb1208_문자열_재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        List<Character> list = new ArrayList<>();
        int sum = 0;
        for (char ch : in.toCharArray()) {
            if (Character.isDigit(ch)) sum += ch - '0';
            else list.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        list.stream().sorted().forEach(sb::append);
        if (sum != 0) sb.append(sum);

        System.out.println(sb);
    }
}
//K1KA5CB7
