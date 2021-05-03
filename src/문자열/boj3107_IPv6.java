package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class boj3107_IPv6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(br.readLine()
                .replace("::", ":*:").split(":"))
                .map(s -> s.equals("*") ? s : String.format("%4s:", s).replace(' ', '0'))
                .collect(Collectors.toList());

        int size = list.size();
        String ret = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

        if (ret.contains("*")) ret = ret.replace("*", "0000:".repeat(9 - size));
        System.out.println(ret.substring(0, 39));
    }
}
