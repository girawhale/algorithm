package 구현.배열_돌리기;

public class prog68645_삼각_달팽이 {
    public int[] solution(int n) {
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] += sum[i - 1] + i;

        int[] ans = new int[sum[n]];
        int num = 1, y = -1, x = 0, k = 0;

        for (int i = n; i > 0; i--, k++) {
            for (int j = 0; j < i; j++) {
                y += dy[k % 3];
                x += dx[k % 3];

                ans[sum[y] + x] = num++;
            }
        }

        return ans;
    }
}
