package 분할정복;

public class prog68936_쿼드압축_후_개수_세기 {
    int[] ans = new int[2];

    public int[] solution(int[][] arr) {
        solve(arr, 0, 0, arr.length);

        return ans;
    }

    void solve(int[][] arr, int y, int x, int n) {
        int base = arr[y][x];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (base != arr[y + i][x + j]) {
                    n /= 2;

                    solve(arr, y, x, n);
                    solve(arr, y, x + n, n);
                    solve(arr, y + n, x, n);
                    solve(arr, y + n, x + n, n);
                    return;
                }
            }
        }

        ans[base] += n;
    }
}
