package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dbb1102_곱하기_혹은_더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int ans = 0;
        for (char ch : input.toCharArray()) {
            int sum = ans + ch - '0';
            int mul = ans * (ch - '0');
            ans = Math.max(sum, mul);
        }
        System.out.println(ans);
    }
}
