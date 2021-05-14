package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dbb04ex1_상하좌우 {
    public static void main(String[] args) throws IOException {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('L', 2);
        map.put('R', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dir = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> map.get(s.charAt(0))).toArray();

        int y = 1, x = 1;
        for (int d : dir) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny <= 0 || nx <= 0 || ny > N || nx >= N) continue;

            y = ny;
            x = nx;
        }
        System.out.println(y + " " + x);


    }
}
//5
//R R R U D D