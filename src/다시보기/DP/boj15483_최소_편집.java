package 다시보기.DP;

import java.util.Scanner;

public class boj15483_최소_편집 { // dbb1636_편집_거리
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String origin = "0" + sc.next();
        String change = "0" + sc.next();

        int N = origin.length(), M = change.length();
        int[][] memo = new int[N][M];

        for (int i = 0; i < N; i++) memo[i][0] = i;
        for (int i = 0; i < M; i++) memo[0][i] = i;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (origin.charAt(i) == change.charAt(j)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 1 +
                            Math.min(memo[i - 1][j - 1], // 교체
                                    Math.min(memo[i][j - 1], // 추가
                                            memo[i - 1][j])); // 삭제
                }
            }
        }

        System.out.println(memo[N - 1][M - 1]);
    }
}
