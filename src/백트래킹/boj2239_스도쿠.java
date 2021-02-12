package 백트래킹;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj2239_스도쿠 {
    static List<int[]> list;
    static int[][] sudoku;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];

        list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int[] in = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = in[j];
                if (sudoku[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        solve(0);
    }

    static void solve(int n) {
        if (n > 0) {
            int[] prev = list.get(n - 1);
            int num = sudoku[prev[0]][prev[1]];
            for (int i = 0; i < 9; i++) {
                if (prev[0] != i && sudoku[i][prev[1]] == num) return;
                if (prev[1] != i && sudoku[prev[0]][i] == num) return;
            }

            for (int i = 0, ii = prev[0] / 3 * 3; i < 3; i++) {
                for (int j = 0, jj = prev[1] / 3 * 3; j < 3; j++) {
                    if (ii + i == prev[0] && jj + j == prev[1]) continue;
                    if (sudoku[ii + i][jj + j] == num) return;
                }
            }
        }

        if (n == list.size()) {
            for (int[] s : sudoku) {
                Arrays.stream(s).forEach(System.out::print);
                System.out.println();
            }
            System.exit(0);
        }

        int[] cur = list.get(n);
        for (int i = 1; i <= 9; i++) {
            sudoku[cur[0]][cur[1]] = i;
            solve(n + 1);
        }
        sudoku[cur[0]][cur[1]] = 0;
    }
}
