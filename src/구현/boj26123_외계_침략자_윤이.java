package 구현;

import java.io.*;
import java.util.*;

public class boj26123_외계_침략자_윤이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];

        int[] building = new int[300_001];
        int max = 0;
        for (int i : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            building[i]++;
            max = Integer.max(max, i);
        }

        long sum = 0,ret = 0;
        while (D-- > 0 && max > 0) ret += (sum += building[max--]);
        System.out.println(ret);
    }
}
