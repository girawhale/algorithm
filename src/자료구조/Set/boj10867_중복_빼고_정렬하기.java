package 자료구조.Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class boj10867_중복_빼고_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            set.add(Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        for (int i : set) sb.append(i).append(' ');
        System.out.println(sb.toString());
    }
}
