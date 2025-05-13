package 구현;

import java.util.*;

public class leetcode54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};

        ArrayList<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

        int d = 0;
        while (res.size() < m * n) {
            while (i < n && j < m && i >= 0 && j >= 0 && !visited[i][j]) {
                visited[i][j] = true;
                res.add(matrix[i][j]);

                i += di[d];
                j += dj[d];
            }

            i -= di[d];
            j -= dj[d];
            d = (d + 1) % 4;
            i += di[d];
            j += dj[d];
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix.length - 1, top = 0, bottom = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            System.out.println(res);
        }
        return res;
    }
}