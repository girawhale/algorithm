package 자료구조.Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj10815_숫자_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0)
            set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0)
            sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(' ');
        System.out.println(sb.toString());
    }
}
