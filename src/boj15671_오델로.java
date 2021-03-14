import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj15671_오델로 {
    public static void main(String[] args) {
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1}, dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        char[] dol = {'B', 'W'};

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[6][6];
        for (char[] m : map) Arrays.fill(m, '.');

        map[2][2] = map[3][3] = 'W';
        map[2][3] = map[3][2] = 'B';

        for (int n = 0; n < N; n++) {
            int r = sc.nextInt() - 1, c = sc.nextInt() - 1, d = n % 2;
            map[r][c] = dol[d];

            for (int k = 0; k < 8; k++) {
                int y = r + dy[k], x = c + dx[k];
                if (outOfRange(y, x) || map[y][x] != dol[1 - d]) continue;

                List<int[]> list = new ArrayList<>();
                while (!outOfRange(y, x) && map[y][x] == dol[1 - d]) {
                    list.add(new int[]{y, x});
                    y += dy[k];
                    x += dx[k];
                }
                if (!outOfRange(y, x) && map[y][x] == dol[d]) {
                    for (int[] p : list) map[p[0]][p[1]] = dol[d];
                }
            }
        }
        int[] cnt = new int[2];
        for (char[] m : map) {
            for (char mm : m) {
                System.out.print(mm);
                if (mm != '.') cnt[mm == 'W' ? 0 : 1]++;
            }
            System.out.println();
        }
        System.out.println(cnt[0] > cnt[1] ? "White" : "Black");
    }

    static boolean outOfRange(int y, int x) {
        return !(y >= 0 && x >= 0 && y < 6 && x < 6);
    }
}
