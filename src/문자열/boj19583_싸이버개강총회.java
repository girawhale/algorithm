package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> enter = new HashSet<>();
        String input;
        int ans = 0;

        while ((input = br.readLine()) != null) {
            String[] split = input.split(" ");
            String time = split[0], name = split[1];

            if (time.compareTo(S) <= 0) enter.add(split[1]);
            else if (time.compareTo(E) >= 0
                    && time.compareTo(Q) <= 0
                    && enter.contains(name)) {
                enter.remove(name);
                ans++;
            }

        }

        System.out.println(ans);
    }
}
