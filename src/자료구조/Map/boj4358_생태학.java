package 자료구조.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int count = 0;
        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            count++;
        }

        double finalCount = count;
        map.keySet().stream().sorted()
                .forEach((key) ->
                        System.out.println(key + " " + String.format("%.4f", (map.get(key) / finalCount) * 100.0)));
    }
}
